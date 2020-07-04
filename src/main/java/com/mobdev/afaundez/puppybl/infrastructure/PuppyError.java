package com.mobdev.afaundez.puppybl.infrastructure;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PuppyError {

    private String status;
    private String message;
    private int code;

}
