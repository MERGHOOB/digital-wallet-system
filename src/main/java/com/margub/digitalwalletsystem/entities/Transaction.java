package com.margub.digitalwalletsystem.entities;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class Transaction {
    private Date creationTime;
    private String fromAccount;
    private String ToAccount;
    private BigDecimal amount;

    public Transaction(String fromAccount, String toAccount, BigDecimal amount) {
        this.fromAccount = fromAccount;
        ToAccount = toAccount;
        this.amount = amount;
        this.creationTime = new Date();
    }

    public Date getDate() {
        return creationTime;
    }
}
