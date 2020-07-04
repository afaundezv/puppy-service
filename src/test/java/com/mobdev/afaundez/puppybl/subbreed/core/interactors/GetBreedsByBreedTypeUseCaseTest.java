package com.mobdev.afaundez.puppybl.subbreed.core.interactors;

import com.mobdev.afaundez.puppybl.subbreed.core.entities.SubBreed;
import com.mobdev.afaundez.puppybl.subbreed.core.exceptions.PuppySubBreedException;
import com.mobdev.afaundez.puppybl.subbreed.gateways.SubBreedExternal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;

@SpringBootTest
public class GetBreedsByBreedTypeUseCaseTest {

    @InjectMocks
    GetSubBreedByBreedTypeUseCase useCase;

    @Mock
    SubBreedExternal subBreedExternal;

    Map<String, List<String>> breeds;

    @BeforeEach
    void setUp() {
        breeds = new HashMap<>();
        breeds.put("chihuahua", Arrays.asList("ch,hua,hua".split(",",-1)));
    }

    @Test
    void testShouldCreateSubBreedByBreedType() {
        String breedType = "chihuahua";
        when(subBreedExternal.findAllBreeds()).thenReturn(breeds);

        SubBreed subBreed = useCase.execute(breedType);

        Assertions.assertFalse(subBreed.getBreeds().isEmpty());

    }

    @Test
    void testShouldThrowPuppySubBreedException() {
        String breedType = "lipigas";
        when(subBreedExternal.findAllBreeds()).thenReturn(breeds);

        Assertions.assertThrows(PuppySubBreedException.class, () -> {
            useCase.execute(breedType);
        });

    }
}
