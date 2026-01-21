package org.juanlopezaranzazu.controller;

import org.juanlopezaranzazu.dto.CommentRequestDTO;
import org.juanlopezaranzazu.dto.CommentResponseDTO;
import org.juanlopezaranzazu.service.CommentService;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/comments")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentController {

    @Inject
    CommentService service;

    @POST
    public Response create(@Valid CommentRequestDTO dto) {
        CommentResponseDTO response = service.create(dto);
        return Response.status(Response.Status.CREATED).entity(response).build();
    }
}
