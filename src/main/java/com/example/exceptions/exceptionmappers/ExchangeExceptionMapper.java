package com.example.exceptions.exceptionmappers;

import com.example.exceptions.ExchangeException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;


public class ExchangeExceptionMapper implements ExceptionMapper<ExchangeException> {

    @Override
    public Response toResponse(ExchangeException exchangeException) {
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(exchangeException.getMessage())
                .type("text/plain")
                .build();
    }
}
