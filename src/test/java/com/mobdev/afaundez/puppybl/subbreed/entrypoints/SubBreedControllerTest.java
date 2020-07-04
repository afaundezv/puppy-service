package com.mobdev.afaundez.puppybl.subbreed.entrypoints;

import com.mobdev.afaundez.puppybl.subbreed.core.entities.SubBreed;
import com.mobdev.afaundez.puppybl.subbreed.core.interactors.GetSubBreedByBreedTypePort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static org.mockito.Mockito.when;

@SpringBootTest
public class SubBreedControllerTest {

    @InjectMocks
    SubBreedController subBreedController;

    @Mock
    GetSubBreedByBreedTypePort breedTypePort;

    @Test
    void testShouldReturnSubBreedsByBreed() {
        String breed = "MyBreed";
        String breeds = "breed1, breed2, breed3";
        when(breedTypePort.execute(breed))
                .thenReturn(new SubBreed(breed, Arrays.asList(breeds.split(",", -1))));

        ResponseEntity<SubBreed> subBreedsResponseEntity = subBreedController.getSubBreedsListByBreedType(breed);

        Assertions.assertNotNull(subBreedsResponseEntity.getBody());
    }
}
