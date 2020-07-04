package com.mobdev.afaundez.puppybl.subbreed.core.interactors;

import com.mobdev.afaundez.puppybl.subbreed.core.entities.SubBreed;
import com.mobdev.afaundez.puppybl.subbreed.gateways.SubBreedExternal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class GetSubBreedByBreedTypeUseCase implements GetSubBreedByBreedTypePort {

    private SubBreedExternal subBreedExternal;

    @Autowired
    public GetSubBreedByBreedTypeUseCase(SubBreedExternal subBreedExternal) {
        this.subBreedExternal = subBreedExternal;
    }

    @Override
    public SubBreed execute(String breed) {
        Map<String, List<String>> allBreeds = subBreedExternal.findAllBreeds();
        SubBreed subBreed = new SubBreed(breed,allBreeds.get(breed));
        subBreed.existBreed();
        return subBreed;
    }

}
