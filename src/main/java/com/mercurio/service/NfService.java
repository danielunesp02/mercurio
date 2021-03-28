package com.mercurio.service;


import com.jayway.jsonpath.JsonPath;
import com.mercurio.model.Customer;
import com.mercurio.model.MetadataList;
import com.mercurio.model.Result;
import com.mercurio.repository.CustomerRepository;
import com.mercurio.repository.DBFileRepository;
import com.mercurio.repository.ResultRepository;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class NfService {

    private static final Logger logger = Logger.getLogger(NfService.class);

    @Autowired
    private DBFileRepository dbFileRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ResultRepository resultRepository;

    /**
     * Pattern parser example
     * "$['ConsultarNfeServPrestadoResposta']['ListaNfeServPrestado']['CompNfeServPrestado']['NfeServPrestado']['InfNfeServPrestado']['NumeroNfe']"
     * "$['ConsultarNfeServPrestadoResposta']['ListaNfeServPrestado']['CompNfeServPrestado']['NfeServPrestado']['InfNfeServPrestado']['DescricaoNfe']"
     * "$.ConsultarNfeServPrestadoResposta.ListaNfeServPrestado.CompNfeServPrestado.NfeServPrestado.InfNfeServPrestado.ValoresNfe.Aliquota"
     * "$..DataEmissao"
     * <p>
     * //System.out.println(getInfoDataByJson(jsonData.toString(), metadata.getNumeroNfe()));
     * //System.out.println(getInfoDataByJson(jsonData.toString(), metadata.getDescricaoNfe()));
     * //System.out.println(getInfoDataByJson(jsonData.toString(), metadata.getDataEmissao()));
     *
     * @param file
     * @param customerId
     */
    public List<Result> nfParser(MultipartFile file, Long customerId) {
        List<Result> results = new ArrayList<Result>();
        String uuid = UUID.randomUUID().toString();
        try {
            logger.info("---------- Processo de validacao de NF : " + file.getOriginalFilename());

            File xmlFile = multipartToFile(file, file.getOriginalFilename());
            String xmlNormalized = normalizeFile(getDocument(xmlFile));
            JSONObject jsonData = XML.toJSONObject(xmlNormalized);

            Customer customer = customerRepository.getOne(customerId);

            for (MetadataList ml : customer.getMetadataList()) {
                String nfValue = getInfoDataByJson(jsonData.toString(), ml.getKey());
                Result result = new Result();
                if (nfValue.equalsIgnoreCase(ml.getValue())) {
                    result.setValid(true);
                    result.setMessage(ml.getValidationPositiveMessage());

                } else {
                    result.setValid(false);
                    result.setMessage(ml.getValidationNegativeMessage());
                }
                result.setExpectedValue(ml.getValue());
                result.setEvidencedValue(nfValue);
                result.setKey(ml.getKey());
                result.setCustomerId(customerId);
                result.setDate(new Date());
                result.setColor(ml.getColor());
                result. setUuid(uuid);
                results.add(result);
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        resultRepository.saveAll(results);
        return results;
    }

    private Document getDocument(File xmlFile) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(xmlFile);
        document.getDocumentElement().normalize();
        return document;
    }


    public static File multipartToFile(MultipartFile multipart, String fileName) throws IllegalStateException, IOException {
        File convFile = new File(System.getProperty("java.io.tmpdir") + "/" + fileName);
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
