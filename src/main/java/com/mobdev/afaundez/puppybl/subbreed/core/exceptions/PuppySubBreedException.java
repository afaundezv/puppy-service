package com.mobdev.afaundez.puppybl.subbreed.core.exceptions;

import lombok.Getter;

@Getter
public class PuppySubBreedException extends RuntimeException {

    private String status = "error";
    private String message = "Breed not found (master breed does not exist)";
    private int code = 404;

    public PuppySubBreedException() {
    }

}
