package com.margub.digitalwalletsystem.repositories;

import com.margub.digitalwalletsystem.entities.Account;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Getter
@Setter
public class WalletRepository {

    //in memory map
    private Map<String, Account> map = new HashMap<>();

    public Optional<Account> get(String accountNumber) {
        return Optional.of(map.get(accountNumber));
    }
}
