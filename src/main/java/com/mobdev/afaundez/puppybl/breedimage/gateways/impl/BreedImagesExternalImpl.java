package com.mobdev.afaundez.puppybl.breedimage.gateways.impl;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobdev.afaundez.puppybl.breedimage.gateways.BreedImagesExternal;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class BreedImagesExternalImpl implements BreedImagesExternal {

    @Value("${breeds.uri}")
    private String path;

    @Value("${breeds.findImages}")
    private String findImages;

    private RestTemplate restTemplate;

    @Autowired
    public BreedImagesExternalImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<String> findImagesListByBreedType(String breedType) {
        String uri = path + findImages.replace("{breedType}", breedType);
        ResponseEntity<String> responseEntity = restTemplate.   getForEntity(uri, String.class);
        return responseToListString(responseEntity.getBody());
    }

    @SneakyThrows
    private List<String> responseToListString(String response) {
        ObjectMapper mapper = new ObjectMapper(new JsonFactory());
        String imagesList = mapper.writeValueAsString(mapper.readTree(response).get("message"));
        String cleanBreedImagesList = cleanString(imagesList);
        return Arrays.asList(cleanBreedImagesList.split(",", -1));
    }

    private String cleanString(String value) {
        return value.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\"", "");
    }
}
