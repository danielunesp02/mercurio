package com.mercurio.controller;

import com.mercurio.model.Document;
import com.mercurio.model.Result;
import com.mercurio.payload.UploadFileResponse;
import com.mercurio.service.DBFileStorageService;
import com.mercurio.service.NfService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private DBFileStorageService dbFileStorageService;

    @Autowired
    private NfService nfService;

    @PostMapping("/uploadFile/{metadataId}")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file, @PathVariable Long metadataId) {
        Document document = dbFileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(document.getId())
                .toUriString();

        // processo de serializacao do XML para Json e busca dos atributos atraves do metadado cadastrado
        List<Result> results = nfService.nfParser(file, metadataId);

        return new UploadFileResponse(document.getFileName(), fileDownloadUri,
                file.getContentType(), file.getSize(), results);
    }

    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFiles(file))
                .collect(Collectors.toList());
    }

    public UploadFileResponse uploadFiles(@RequestParam("file") MultipartFile file) {
        Document document = dbFileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(document.getId())
                .toUriString();

        List<Result> results = new ArrayList<>();

        return new UploadFileResponse(document.getFileName(), fileDownloadUri,
                file.getContentType(), file.getSize(), results);
    }

    @GetMapping("/downloadFile/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) {
        // Load file from database
        Document document = dbFileStorageService.getFile(fileId);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(document.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + document.getFileName() + "\"")
                .body(new ByteArrayResource(document.getData()));
    }

}
