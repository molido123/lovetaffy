package com.ayano.lovetaffy.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author huagenda
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private String status;
    private Object content;
}
