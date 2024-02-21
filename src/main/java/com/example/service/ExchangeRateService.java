package com.example.service;

import com.example.clients.ExchangeRateClient;
import com.example.models.ExchangeRateResponseDTO;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.math.BigDecimal;

@ApplicationScoped
public class ExchangeRateService {

    @Inject
    @RestClient
    ExchangeRateClient exchangeRateClient;

    public ExchangeRateResponseDTO getExchangeRate(String baseCurrency, String targetCurrency) {
        return exchangeRateClient.getExchangeRate(baseCurrency, targetCurrency);
    }

    public ExchangeRateResponseDTO convertAmount(String baseCurrency, String targetCurrency, BigDecimal amount) {
        return exchangeRateClient.convertAmount(baseCurrency, targetCurrency, amount);
    }
}
