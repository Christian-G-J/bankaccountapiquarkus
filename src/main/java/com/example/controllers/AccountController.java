package com.example.controllers;

import com.example.exceptions.AccountException;
import com.example.models.Account;
import com.example.models.ExchangeRateResponseDTO;
import com.example.service.AccountService;
import com.example.service.ExchangeRateService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Path("/accounts")
public class AccountController {

    @Inject
    AccountService accountService;

    @Inject
    @RestClient
    ExchangeRateService exchangeRateService;

    @GET
    @Path("/{accountNumber}/balance")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBalance(@PathParam("accountNumber") String accountNumber) {
        try {
            BigDecimal balance = accountService.findBalanceById(accountNumber);
            return Response.ok("Balance of " + accountNumber + " is = " + balance).build();
        } catch (AccountException e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(e.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createAccount(@Valid Account account) {
        try {
            Account createdAccount = accountService.createAccount(account);
            return Response.status(Response.Status.CREATED).entity(createdAccount).build();
        } catch (AccountException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("{accountNumber}/deposit")
    public Response deposit(@PathParam("accountNumber") String accountNumber,
                            @QueryParam("amount") @Positive BigDecimal amount) {
        try {
            BigDecimal newBalance = accountService.deposit(accountNumber, amount);
            return Response.ok("New balance: " + newBalance).build();
        } catch (AccountException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage()).build();
        }
    }
}
