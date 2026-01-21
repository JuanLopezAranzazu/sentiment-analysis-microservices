package org.juanlopezaranzazu.service;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.juanlopezaranzazu.dto.SentimentRequestDTO;
import org.juanlopezaranzazu.dto.SentimentResponseDTO;

@Path("/api")
@RegisterRestClient(configKey = "sentiment-api")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface SentimentClient {

    @POST
    @Path("/analyze")
    SentimentResponseDTO analyze(SentimentRequestDTO request);
}
