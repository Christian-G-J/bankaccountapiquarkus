package com.example.mapper;

import com.example.exceptions.ExchangeException;
import com.example.models.ExchangeRateResponseDTO;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ExchangeRateResponseMapper {

    public static Map<String, Object> jsonMapper(ExchangeRateResponseDTO exchangeRateResponseDTO, BigDecimal amount) {
        if (exchangeRateResponseDTO == null) {
            throw new ExchangeException("ExchangeRateResponseDTO is null.");
        }

        try {
            Map<String, Object> result = new HashMap<>();
            result.put("base_code", exchangeRateResponseDTO.getBase());
            result.put("target_code", exchangeRateResponseDTO.getTarget());
            result.put("conversion_rate", exchangeRateResponseDTO.getConversionRate());
            if (amount != null) {
                result.put("amount", amount);
                result.put("conversion_result", exchangeRateResponseDTO.getConversionResult());
            }
            return result;
        } catch (Exception e) {
            throw new ExchangeException("An error occurred while mapping object: " + e.getMessage());
        }
    }
}
