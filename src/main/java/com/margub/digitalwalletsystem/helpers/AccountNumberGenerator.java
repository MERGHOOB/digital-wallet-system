package com.margub.digitalwalletsystem.helpers;

public class AccountNumberGenerator {

    private static long currentNumber = 1;

    public static String getAccountNumber() {
        return String.valueOf(currentNumber++);
    }
}
