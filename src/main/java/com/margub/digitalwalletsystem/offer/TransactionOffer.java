package com.margub.digitalwalletsystem.offer;

import com.margub.digitalwalletsystem.entities.Account;
import com.margub.digitalwalletsystem.entities.Transaction;

import java.math.BigDecimal;
import java.util.List;

public class TransactionOffer {
    private static final BigDecimal reward = BigDecimal.TEN; // this value can be configured


    public static void addRewardIfPossible(List<Account> accounts) {
        if(!validate(accounts)) {
            return;
        }
        for (Account account : accounts) {
            account.setBalance(account.getBalance().add(reward));
            account.getTransactions().add(new Transaction("REWARD", account.getAccountNumber(), reward));
        }
    }

    private static boolean validate(List<Account> accounts) {
        return accounts.get(0) .getBalance().equals(accounts.get(1).getBalance());
    }
}
