package com.example.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Account {

    @Id
    @NotBlank(message = "Account number must not be empty")
    private String accountNumber;

    @DecimalMin(value = "0", inclusive = false, message = "Balance must be greater than 0")
    private BigDecimal balance = BigDecimal.ZERO;

    @NotBlank(message = "First name must not be empty")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "First name must contain only alphabetic characters and spaces")
    private String firstName;

    @NotBlank(message = "Last name must not be empty")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Last name must contain only alphabetic characters and spaces")
    private String lastName;
}
