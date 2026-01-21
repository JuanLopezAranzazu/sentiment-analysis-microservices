package org.juanlopezaranzazu.dto;

import java.time.LocalDateTime;

public class CommentResponseDTO {

    public Long id;
    public String text;
    public String sentiment;
    public Double confidence;
    public LocalDateTime createdAt;
}
