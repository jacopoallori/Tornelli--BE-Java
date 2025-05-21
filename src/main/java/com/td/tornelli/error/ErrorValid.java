package com.td.tornelli.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorValid {
    private String field;
    private String message;
}
