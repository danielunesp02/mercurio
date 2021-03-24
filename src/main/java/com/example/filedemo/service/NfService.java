package com.example.filedemo.service;


import com.example.filedemo.repository.DBFileRepository;
import com.jayway.jsonpath.JsonPath;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class NfService {

    @Autowired
    private DBFileRepository dbFileRepository;

    public void nfParser(MultipartFile file) {
        try {
            File xmlFile = multipartToFile(file, file.getOriginalFilename());

            String xmlNormalized = normalizeFile(getDocument(xmlFile));

            JSONObject jsonData = XML.toJSONObject(xmlNormalized);

            String numeroNfe = "$['ConsultarNfeServPrestadoResposta']['ListaNfeServPrestado']['CompNfeServPrestado']['NfeServPrestado']['InfNfeServPrestado']['NumeroNfe']";
            String descricaoNfe = "$['ConsultarNfeServPrestadoResposta']['ListaNfeServPrestado']['CompNfeServPrestado']['NfeServPrestado']['InfNfeServPrestado']['DescricaoNfe']";
            String dataEmissao = "$['ConsultarNfeServPrestadoResposta']['ListaNfeServPrestado']['CompNfeServPrestado']['NfeServPrestado']['InfNfeServPrestado']['DataEmissao']";

            System.out.println(getInfoDataByJson(jsonData.toString(), numeroNfe));
            System.out.println(getInfoDataByJson(jsonData.toString(), descricaoNfe));
            System.out.println(getInfoDataByJson(jsonData.toString(), dataEmissao));

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private Document getDocument(File xmlFile) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(xmlFile);
        document.getDocumentElement().normalize();
        return document;
    }


    public  static File multipartToFile(MultipartFile multipart, String fileName) throws IllegalStateException, IOException {
        File convFile = new File(System.getProperty("java.io.tmpdir")+"/"+fileName);
        multipart.transferTo(convFile);
        return convFile;
    }


    public static String getInfoDataByJson(String json, String path) {
        return JsonPath.read(json, path).toString();
    }


    public static String normalizeFile(Document doc) {
        try {
            StringWriter sw = new StringWriter();
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.transform(new DOMSource(doc), new StreamResult(sw));
            return sw.toString();
        } catch (Exception ex) {
            throw new RuntimeException("Error converting to String", ex);
        }
    }

}
