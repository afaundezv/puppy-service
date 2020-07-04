package com.mobdev.afaundez.puppybl.subbreed.core.entities;

import com.mobdev.afaundez.puppybl.subbreed.core.exceptions.PuppySubBreedException;
import lombok.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SubBreed {

    String breed;
    List<String> breeds;

    public void existBreed() {
        if (!Optional.ofNullable(breeds).isPresent()) {
            throw new PuppySubBreedException();
        }
    }
}
