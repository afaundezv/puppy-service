package com.mobdev.afaundez.puppybl.subbreed.gateways.impl;

import com.mobdev.afaundez.puppybl.subbreed.gateways.SubBreedExternal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;


@SpringBootTest
public class SubBreedExternalImplTest {

    @Autowired
    SubBreedExternal subBreedExternal;
    String response;
    String uri;

    @Mock
    RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        uri = "https://dog.ceo/api/breeds/list/all";
        response = "{\"message\":{\"affenpinscher\":[],\"african\":[],\"airedale\":[],\"akita\":[],\"appenzeller\":[],\"australian\":[\"shepherd\"],\"basenji\":[],\"beagle\":[],\"bluetick\":[],\"borzoi\":[],\"bouvier\":[],\"boxer\":[],\"brabancon\":[],\"briard\":[],\"buhund\":[\"norwegian\"],\"bulldog\":[\"boston\",\"english\",\"french\"],\"bullterrier\":[\"staffordshire\"],\"cairn\":[],\"cattledog\":[\"australian\"],\"chihuahua\":[],\"chow\":[],\"clumber\":[],\"cockapoo\":[],\"collie\":[\"border\"],\"coonhound\":[],\"corgi\":[\"cardigan\"],\"cotondetulear\":[],\"dachshund\":[],\"dalmatian\":[],\"dane\":[\"great\"],\"deerhound\":[\"scottish\"],\"dhole\":[],\"dingo\":[],\"doberman\":[],\"elkhound\":[\"norwegian\"],\"entlebucher\":[],\"eskimo\":[],\"finnish\":[\"lapphund\"],\"frise\":[\"bichon\"],\"germanshepherd\":[],\"greyhound\":[\"italian\"],\"groenendael\":[],\"havanese\":[],\"hound\":[\"afghan\",\"basset\",\"blood\",\"english\",\"ibizan\",\"plott\",\"walker\"],\"husky\":[],\"keeshond\":[],\"kelpie\":[],\"komondor\":[],\"kuvasz\":[],\"labrador\":[],\"leonberg\":[],\"lhasa\":[],\"malamute\":[],\"malinois\":[],\"maltese\":[],\"mastiff\":[\"bull\",\"english\",\"tibetan\"],\"mexicanhairless\":[],\"mix\":[],\"mountain\":[\"bernese\",\"swiss\"],\"newfoundland\":[],\"otterhound\":[],\"ovcharka\":[\"caucasian\"],\"papillon\":[],\"pekinese\":[],\"pembroke\":[],\"pinscher\":[\"miniature\"],\"pitbull\":[],\"pointer\":[\"german\",\"germanlonghair\"],\"pomeranian\":[],\"poodle\":[\"miniature\",\"standard\",\"toy\"],\"pug\":[],\"puggle\":[],\"pyrenees\":[],\"redbone\":[],\"retriever\":[\"chesapeake\",\"curly\",\"flatcoated\",\"golden\"],\"ridgeback\":[\"rhodesian\"],\"rottweiler\":[],\"saluki\":[],\"samoyed\":[],\"schipperke\":[],\"schnauzer\":[\"giant\",\"miniature\"],\"setter\":[\"english\",\"gordon\",\"irish\"],\"sheepdog\":[\"english\",\"shetland\"],\"shiba\":[],\"shihtzu\":[],\"spaniel\":[\"blenheim\",\"brittany\",\"cocker\",\"irish\",\"japanese\",\"sussex\",\"welsh\"],\"springer\":[\"english\"],\"stbernard\":[],\"terrier\":[\"american\",\"australian\",\"bedlington\",\"border\",\"dandie\",\"fox\",\"irish\",\"kerryblue\",\"lakeland\",\"norfolk\",\"norwich\",\"patterdale\",\"russell\",\"scottish\",\"sealyham\",\"silky\",\"tibetan\",\"toy\",\"westhighland\",\"wheaten\",\"yorkshire\"],\"vizsla\":[],\"waterdog\":[\"spanish\"],\"weimaraner\":[],\"whippet\":[],\"wolfhound\":[\"irish\"]},\"status\":\"success\"}";
    }

    @Test
    void testShouldReturnMap() {
        when(restTemplate.getForEntity(uri, String.class)).thenReturn(new ResponseEntity<>(response, HttpStatus.OK));

        Map<String, List<String>> allBreeds = subBreedExternal.findAllBreeds();

        Assertions.assertNotNull(allBreeds);

    }
}
