package com.margub.digitalwalletsystem.service;

import com.margub.digitalwalletsystem.entities.Account;
import com.margub.digitalwalletsystem.entities.Transaction;
import com.margub.digitalwalletsystem.offer.TransactionOffer;
import com.margub.digitalwalletsystem.repositories.WalletRepository;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
Class has all the functionlity to computation related
 */
@Getter
@Setter
public class WalletService {

    private WalletRepository walletRepository;

    public WalletService() {
        this.walletRepository = new WalletRepository();
    }

    //CreateWallet
    public void addAmount(String accountNumber, BigDecimal amount) {
        Account account = walletRepository.getMap().get(accountNumber);
        account.setBalance(account.getBalance().add(amount));
    }

    public void transfer(String from, String to, BigDecimal amount) {

        Account toAccount = walletRepository.getMap().get(to);
        Account fromAccount = walletRepository.getMap().get(from);

        fromAccount.setBalance(fromAccount.getBalance().subtract(amount));
        toAccount.setBalance(toAccount.getBalance().add(amount));

        Transaction transaction = new Transaction(from, to, amount);
        toAccount.getTransactions().add(transaction);
        fromAccount.getTransactions().add(transaction);

        //EVENT will be triggered
        TransactionOffer.addRewardIfPossible(List.of(toAccount, fromAccount));
    }

    //This method should move in WalletController
    public void statement(String accountNumber){
        Optional<Account> account = walletRepository.get(accountNumber);
        if(account.isEmpty()) {
            System.out.println("Account NOT Found Exception thrown");
        }
        System.out.println("Summary for account number: " + accountNumber);
        System.out.println("Current Balance: " + account.get().getBalance());
        System.out.println("Your Transaction History");
        System.out.println(account.get().getTransactions());
    }

    public void overview() {
        Map<String, Account> map = walletRepository.getMap();
        map.keySet().forEach(key -> {
            System.out.println("Balance for account number " + key + ": " + map.get(key).getBalance());
        });
    }


    public String createAccount(String userId) {
        Account account = new Account(userId, BigDecimal.ZERO);
        walletRepository.getMap().put(account.getAccountNumber(), account);
        return account.getAccountNumber();
    }
}
