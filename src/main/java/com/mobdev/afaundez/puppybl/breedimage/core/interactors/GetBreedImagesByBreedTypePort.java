package com.mobdev.afaundez.puppybl.breedimage.core.interactors;

import java.util.List;

public interface GetBreedImagesByBreedTypePort {

    List<String> execute(String breed);
}
