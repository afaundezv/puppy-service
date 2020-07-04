package com.mobdev.afaundez.puppybl.breedimage.core.interactors;

import com.mobdev.afaundez.puppybl.breedimage.gateways.BreedImagesExternal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetBreedImagesByBreedTypeUseCase implements GetBreedImagesByBreedTypePort {

    private BreedImagesExternal breedImagesExternal;

    @Autowired
    public GetBreedImagesByBreedTypeUseCase(BreedImagesExternal breedImagesExternal) {
        this.breedImagesExternal = breedImagesExternal;
    }

    @Override
    public List<String> execute(String breed) {
        return breedImagesExternal.findImagesListByBreedType(breed);
    }

}
