package org.juanlopezaranzazu.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false, length = 1000)
    public String text;

    public String sentiment;

    public Double confidence;

    public LocalDateTime createdAt = LocalDateTime.now();
}
