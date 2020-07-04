package com.mobdev.afaundez.puppybl.breedimage.entrypoints;

import com.mobdev.afaundez.puppybl.breedimage.core.interactors.GetBreedImagesByBreedTypePort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class BreedImagesControllerTest {

    @InjectMocks
    BreedImagesController breedImagesController;

    @Mock
    GetBreedImagesByBreedTypePort breedTypePort;

    @Test
    void testShouldReturnSubBreedsByBreed() {
        String breed = "MyBreed";
        String breeds = "breed1, breed2, breed3";
        when(breedTypePort.execute(breed))
                .thenReturn(Arrays.asList(breed.split(",", -1)));

        ResponseEntity<List<String>> subBreedsResponseEntity = breedImagesController.getSubBreedsListByBreedType(breed);

        Assertions.assertNotNull(subBreedsResponseEntity.getBody());
    }
}
