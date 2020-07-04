package com.mobdev.afaundez.puppybl.subbreed.core.interactors;

import com.mobdev.afaundez.puppybl.subbreed.core.entities.SubBreed;

public interface GetSubBreedByBreedTypePort {

    SubBreed execute(String breed);
}
