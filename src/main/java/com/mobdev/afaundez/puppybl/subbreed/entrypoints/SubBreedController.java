package com.mobdev.afaundez.puppybl.subbreed.entrypoints;

import com.mobdev.afaundez.puppybl.subbreed.core.entities.SubBreed;
import com.mobdev.afaundez.puppybl.subbreed.core.interactors.GetSubBreedByBreedTypePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/puppyservice/")
public class SubBreedController {

    @Autowired
    private GetSubBreedByBreedTypePort breedTypePort;

    @GetMapping("{breed}/subbreeds")
    public ResponseEntity<SubBreed> getSubBreedsListByBreedType(@PathVariable("breed") String breed) {
        SubBreed subBreed = breedTypePort.execute(breed);
        return new ResponseEntity<>(subBreed, OK);
    }
}
