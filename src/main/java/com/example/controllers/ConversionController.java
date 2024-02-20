package com.example.controllers;

import com.example.mapper.ExchangeRateResponseMapper;
import com.example.models.ExchangeRateResponseDTO;
import com.example.service.ExchangeRateService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Path("/convert")
public class ConversionController {

    @Inject
    @RestClient
    ExchangeRateService exchangeRateService;

    @GET
    @Path("/{base}/to/{target}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getConversion(@PathParam("base") String base,
                                  @PathParam("target") String target,
                                  @QueryParam("amount") BigDecimal amount) {
        ExchangeRateResponseDTO response = amount != null ? exchangeRateService.convertAmount(base, target, amount) : exchangeRateService.getExchangeRate(base, target);
        Map<String, Object> result = ExchangeRateResponseMapper.jsonMapper(response, amount);
        return Response.ok(result).build();
    }
}
