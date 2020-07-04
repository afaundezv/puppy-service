package com.mobdev.afaundez.puppybl.breedimage.gateways.impl;

import com.mobdev.afaundez.puppybl.breedimage.gateways.BreedImagesExternal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.mockito.Mockito.when;


@SpringBootTest
public class BreedImagesExternalImplTest {

    @Autowired
    BreedImagesExternal breedImagesExternal;

    @Mock
    RestTemplate restTemplate;

    String response;
    String uri;


    @BeforeEach
    void setUp() {
        uri = "https://dog.ceo/api/breed/chihuahua/images";
        response = "{\"message\": [\"https://images.dog.ceo/breeds/retriever-golden/n02099601_3414.jpg\", \"https://images.dog.ceo/breeds/mix/Annabelle7.jpeg\", \"https://images.dog.ceo/breeds/hound-blood/n02088466_9069.jpg\"]},\"status\": \"success\"";
    }

    @Test
    void testShouldReturnImagesList() {
        String breedType = "chihuahua";
        when(restTemplate.getForEntity(uri, String.class)).thenReturn(new ResponseEntity<>(response, HttpStatus.OK));

        List<String> imagesListByBreedType = breedImagesExternal.findImagesListByBreedType(breedType);

        Assertions.assertNotNull(imagesListByBreedType);

    }

    @Test
    void  testShouldThrowHttpClientErrorException(){

        Assertions.assertThrows(HttpClientErrorException.class, () -> breedImagesExternal.findImagesListByBreedType("lipigas"));
    }
}
