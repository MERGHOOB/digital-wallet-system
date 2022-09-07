package com.margub.digitalwalletsystem;

import com.margub.digitalwalletsystem.service.UserService;
import com.margub.digitalwalletsystem.service.WalletService;

import java.math.BigDecimal;

public class WalletController {

    private WalletService walletService;
    private UserService userService;

    public WalletController(WalletService walletService, UserService userService) {
        this.walletService = walletService;
        this.userService = userService;
    }

    public void createWallet(String name, String amount) {
        //Assuming this method always create a new wallet
        // name and amount cannot be unique
        //Let's create a user first
        String userId = userService.createUser(name);
        String accountNumber = walletService.createAccount(userId);
        walletService.addAmount(accountNumber, toBigDecimal(amount));
    }

    private BigDecimal toBigDecimal(String amount) {
        return BigDecimal.valueOf(Double.parseDouble(amount));
    }

    public void transferAmount(String from, String to, String amount) {
        walletService.transfer(from, to, toBigDecimal(amount));
    }

    public void accountStatement(String accountNumber) {
        walletService.statement(accountNumber);
    }

    public void overview() {
        walletService.overview();
    }

}
