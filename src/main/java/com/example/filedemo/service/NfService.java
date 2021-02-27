package com.example.filedemo.service;


import com.example.filedemo.repository.DBFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class NfService {

    @Autowired
    private DBFileRepository dbFileRepository;

    public void nfParser(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());



    }

}
