package com.domain.devcinelocadora.dto.error;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FieldMessage {
    private String fieldName;
    private String message;
}
