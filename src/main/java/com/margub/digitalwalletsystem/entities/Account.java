package com.margub.digitalwalletsystem.entities;

import com.margub.digitalwalletsystem.helpers.AccountNumberGenerator;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;
import java.util.TreeSet;

@Getter
@Setter
public class Account {

    // userid
    // list of transcation
    // Balance
    // FD amount
    // offer

    // Offer1
    //Offer2
    //Offer3

    String accountNumber;
    String userId;
    private BigDecimal balance;
    private Set<Transaction> transactions;

    public Account(String userId, BigDecimal balance) {
        accountNumber = AccountNumberGenerator.getAccountNumber();
        this.userId = userId;
        this.balance = balance;
        this.transactions = new TreeSet<>((a, b) -> a.getDate().compareTo(b.getDate()));
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", transaction=" + transactions +
                '}';
    }
}
