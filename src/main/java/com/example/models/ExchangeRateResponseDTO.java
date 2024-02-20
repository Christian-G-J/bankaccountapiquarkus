package com.example.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

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

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
// Getters and Setters

    public BigDecimal getConversionRate() {
        return conversionRate;
    }

    // Used by Jackson
    public void setConversionRate(BigDecimal conversionRate) {
        this.conversionRate = conversionRate;
    }

    public BigDecimal getConversionResult() {
        return conversionResult;
    }

    // Used by Jackson
    public void setConversionResult(BigDecimal conversionResult) {
        this.conversionResult = conversionResult;
    }
}
