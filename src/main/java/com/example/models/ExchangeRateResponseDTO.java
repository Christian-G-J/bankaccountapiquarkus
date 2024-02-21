package com.example.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRateResponseDTO {

    @JsonProperty("conversion_rate")
    private BigDecimal conversionRate;

    @JsonProperty("conversion_result")
    private BigDecimal conversionResult;

    @JsonProperty("base_code")
    private String base;

    @JsonProperty("target_code")
    private String target;
}
