package com.mobdev.afaundez.puppybl.breedimage.interactor;

import com.mobdev.afaundez.puppybl.breedimage.core.interactors.GetBreedImagesByBreedTypeUseCase;
import com.mobdev.afaundez.puppybl.breedimage.gateways.BreedImagesExternal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class GetBreedImagesByBreedTypeUseCaseTest {

    @InjectMocks
    GetBreedImagesByBreedTypeUseCase useCase;

    @Mock
    BreedImagesExternal breedImagesExternal;

    List<String> breedImages;

    @BeforeEach
    void setUp() {
        breedImages = Arrays.asList("image1,image2,image3".split(",", -1));
    }

    @Test
    void testShouldCreateBreedImagesListByBreedType() {
        String breedType = "chihuahua";
        when(breedImagesExternal.findImagesListByBreedType(breedType)).thenReturn(breedImages);

        List<String> breedImages = useCase.execute(breedType);

        Assertions.assertFalse(breedImages.isEmpty());

    }
}
