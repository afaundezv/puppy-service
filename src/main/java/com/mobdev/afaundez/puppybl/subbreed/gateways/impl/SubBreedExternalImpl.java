package com.mobdev.afaundez.puppybl.subbreed.gateways.impl;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobdev.afaundez.puppybl.subbreed.gateways.SubBreedExternal;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class SubBreedExternalImpl implements SubBreedExternal {

    @Value("${breeds.uri}")
    private String path;

    @Value("${breeds.findAll}")
    private String findAll;

    private RestTemplate restTemplate;

    @Autowired
    public SubBreedExternalImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Map<String, List<String>> findAllBreeds() {
        String uri = path + findAll;
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
        return mapResponse(response.getBody());
    }

    @SneakyThrows
    private Map<String, List<String>> mapResponse(String response) {
        Map<String, List<String>> breedsMap = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper(new JsonFactory());

        JsonNode breeds = mapper.readTree(response).get("message");
        Iterator<Map.Entry<String, JsonNode>> fields = breeds.fields();

        while (fields.hasNext()) {
            Map.Entry<String, JsonNode> entry = fields.next();
            String cleanBreedList = cleanString(mapper.writeValueAsString(entry.getValue()));
            breedsMap.put(entry.getKey(), Arrays.asList(cleanBreedList.split(",", -1)));
        }
        return breedsMap;
    }

    private String cleanString(String value) {
        return value.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\"", "");
    }
}
