package com.mobdev.afaundez.puppybl.breedimage.entrypoints;

import com.mobdev.afaundez.puppybl.breedimage.core.interactors.GetBreedImagesByBreedTypePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/puppyservice/")
public class BreedImagesController {

    @Autowired
    private GetBreedImagesByBreedTypePort breedTypePort;

    @GetMapping("{breed}/images")
    public ResponseEntity<List<String>> getSubBreedsListByBreedType(@PathVariable("breed") String breed) {
        List<String> breedImages = breedTypePort.execute(breed);
        return new ResponseEntity<>(breedImages, OK);
    }
}
