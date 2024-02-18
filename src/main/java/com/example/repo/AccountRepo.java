package com.example.repo;

import com.example.models.Account;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AccountRepo implements PanacheRepository<Account> {
}
