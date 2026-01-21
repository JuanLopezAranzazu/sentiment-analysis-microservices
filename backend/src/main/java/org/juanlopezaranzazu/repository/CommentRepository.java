package org.juanlopezaranzazu.repository;

import org.juanlopezaranzazu.entity.Comment;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CommentRepository implements PanacheRepository<Comment> {
}