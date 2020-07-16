package org.xpdojo.bank;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;
import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    @Test
    @Disabled
    // @Disabled
    public void depositAnAmountToIncreaseTheBalance() {
        assertThat("your first test").isBlank();
        // assertThat("your first test").isBlank();

        Account testAccount = new Account("22222", 100);
        //assertThat("your GEE first test isn't implemented", true, is(false));
        testAccount.depositAmount(50);
        Assertions.assertTrue(testAccount.getBalance()==150.0);

        testAccount.printReport();
        //assertThat("your first test").isBlank();
        System.out.println("Your first test case goes here");
    }
    public void depositMultipleAmountToIncreaseTheBalance() {
        // assertThat("your first test").isBlank();

        Account testAccount = new Account("11111", 100);
        //assertThat("your GEE first test isn't implemented", true, is(false));
        testAccount.depositAmount(50);
        testAccount.depositAmount(70);
        Assertions.assertTrue(testAccount.getBalance()==120.0);

        testAccount.printReport();
        //assertThat("your first test").isBlank();
        System.out.println("Your first test case goes here");
    }
    @Test
    //@Disabled
    public void withdrawAnAmountToDecreaseTheBalance() {
        Account testAccount = new Account("11111", 100);
        //assertThat("your GEE first test isn't implemented", true, is(false));
        testAccount.withdrawAmount(50);
        Assertions.assertTrue(testAccount.getBalance()==50.0);
        testAccount.printReport();
    }
    @Test
    //@Disabled
    public  void transferAnAmountBetweenAccounts() {
        Account fromAccount = new Account("11111", 100);
        Account toAccount = new Account("222222", 150);
        //assertThat("your GEE first test isn't implemented", true, is(false));
        Account.transferFunds(fromAccount, toAccount, 50.0 ) ;
        Assertions.assertTrue(fromAccount.getBalance()==50.0 && toAccount.getBalance()==200.0);

    }
    @Test
    public  void transferAnAmountInSufficientFunds() {
        Account fromAccount = new Account("11111", 100);
        Account toAccount = new Account("222222", 150);
        //assertThat("your GEE first test isn't implemented", true, is(false));
        Account.transferFunds(fromAccount, toAccount, 250.0 ) ;
        Assertions.assertTrue(fromAccount.getBalance()==100.0 && toAccount.getBalance()==150.0);

    }

    @Test
    public  void printAcitivity() {
        Account testAccount = new Account("11111", 100);
        testAccount.printReport();
        Assertions.assertTrue(testAccount.getBalance()==100.0 );
    }
    @Test
    public  void printBalanceReport() {
        Account testAccount = new Account("11111", 100);
        testAccount.printBalanceReport();
        Assertions.assertTrue(testAccount.getBalance()==100.0 );
    }




}