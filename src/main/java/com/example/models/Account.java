package com.example.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
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

    public Account(String accountNumber, BigDecimal balance, String firstName, String lastName) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Account() {
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
