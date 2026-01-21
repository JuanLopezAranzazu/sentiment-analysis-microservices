package org.juanlopezaranzazu.dto;

import jakarta.validation.constraints.NotBlank;

public class CommentRequestDTO {

    @NotBlank
    public String text;
}
