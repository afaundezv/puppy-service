package com.mobdev.afaundez.puppybl.breedimage.gateways;

import java.util.List;

public interface BreedImagesExternal {

    List<String> findImagesListByBreedType(String breedType);
}
