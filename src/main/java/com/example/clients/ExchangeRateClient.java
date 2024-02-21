package com.example.clients;

import com.example.models.ExchangeRateResponseDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.*;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import jakarta.ws.rs.core.MediaType;

import java.math.BigDecimal;

@RegisterRestClient(configKey="exchange-rate-api")
@ApplicationScoped
public interface ExchangeRateClient {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/pair/{base}/{target}")
    ExchangeRateResponseDTO getExchangeRate(@PathParam("base") String baseCurrency, @PathParam("target") String targetCurrency);

    @GET
    @Path("/pair/{base}/{target}/{amount}")
    @Produces(MediaType.APPLICATION_JSON)
    ExchangeRateResponseDTO convertAmount(@PathParam("base") String baseCurrency, @PathParam("target") String targetCurrency, @PathParam("amount") BigDecimal amount);
}