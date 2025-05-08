package com.domain.devcinelocadora.dto.error;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
public class CustomError {
    private Instant timestamp;
    private Integer status;
    private String error;
    private String path;
    private List<FieldMessage> fieldMessages;
}
