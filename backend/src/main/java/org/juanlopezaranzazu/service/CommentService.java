package org.juanlopezaranzazu.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.juanlopezaranzazu.dto.CommentRequestDTO;
import org.juanlopezaranzazu.dto.CommentResponseDTO;
import org.juanlopezaranzazu.dto.SentimentRequestDTO;
import org.juanlopezaranzazu.dto.SentimentResponseDTO;
import org.juanlopezaranzazu.entity.Comment;
import org.juanlopezaranzazu.repository.CommentRepository;

@ApplicationScoped
public class CommentService {

    @Inject
    CommentRepository repository;

    @Inject
    @RestClient
    SentimentClient sentimentClient;

    @Transactional
    public CommentResponseDTO create(CommentRequestDTO dto) {


        SentimentRequestDTO request = new SentimentRequestDTO();
        request.text = dto.text;

        SentimentResponseDTO sentiment = sentimentClient.analyze(request);

        Comment comment = new Comment();
        comment.text = dto.text;
        comment.sentiment = sentiment.sentiment;
        comment.confidence = sentiment.confidence;

        repository.persist(comment);


        CommentResponseDTO response = new CommentResponseDTO();
        response.id = comment.id;
        response.text = comment.text;
        response.sentiment = comment.sentiment;
        response.confidence = comment.confidence;
        response.createdAt = comment.createdAt;

        return response;
    }
}