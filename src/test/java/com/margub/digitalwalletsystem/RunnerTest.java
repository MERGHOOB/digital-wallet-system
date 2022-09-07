package com.margub.digitalwalletsystem;

import com.margub.digitalwalletsystem.service.UserService;
import com.margub.digitalwalletsystem.service.WalletService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringJoiner;

public class RunnerTest {


    private static WalletController walletController;
    private static UserService userService;
    private static WalletService walletService;

    @BeforeEach
    public void before() {
        userService = new UserService();
        walletService = new WalletService();
        walletController = new WalletController(walletService, userService);
    }

    @Test
    public void runnerTest() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        boolean doExit = false;
        do {

            System.out.println(getOptions());

            int next = Integer.parseInt(bufferedReader.readLine());
            switch (next) {
                case 1:
                    System.out.println("YOU SELECTED CREATE WALLET");
                    System.out.println("Enter name");
                    String name = bufferedReader.readLine();
                    System.out.println("Enter amount");
                    String amount = bufferedReader.readLine();
                    walletController.createWallet(name, amount);
                    break;
                case 2:
                    System.out.println("YOU SELECTED TRANSFER");
                    System.out.println("Enter SENDER account number");
                    String sender = bufferedReader.readLine();
                    System.out.println("Enter RECEIVER account number");
                    String receiver = bufferedReader.readLine();
                    System.out.println("Enter amount");
                    amount = bufferedReader.readLine();
                    walletController.transferAmount(sender, receiver, amount);
                    break;
                case 3:
                    System.out.println("YOU SELECTED ACCOUNT STATEMENT");
                    System.out.println("Enter account number");
                    String account = bufferedReader.readLine();
                    walletController.accountStatement(account);
                    break;

                case 4:
                    System.out.println("YOU SELECTED OVERVIEW");
                    walletController.overview();
                    break;
                case 5:
                    System.out.println("YOU SELECTED EXIT");
                    doExit = true;
                    break;

                default:
                    System.out.println("YOU HAVE SELECTED AN INVALID OPTION");
                    break;
            }

        } while (!doExit);
    }

//    private String getInput() {
//        return
//    }

    private String getOptions() {

        StringJoiner stringJoiner = new StringJoiner("\n");
        stringJoiner.add("OPTIONS:");
        stringJoiner.add("1. Create Wallet");
        stringJoiner.add("2. Transfer Amount");
        stringJoiner.add("3. Account Statement");
        stringJoiner.add("4. Overview");
        stringJoiner.add("5. EXIT");


        return stringJoiner.toString();
    }
}
