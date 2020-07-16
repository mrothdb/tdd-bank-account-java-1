package org.xpdojo.bank;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Account {
    private String acctNumber;
    private double balance;
    private Date businessDate;
    private String transactionActivity = null;

    public Account() {
        businessDate = new Date();
        balance = 0;
    }
    public Account(String acctNum, double initialBalance)
    {
        acctNumber = acctNum;
        balance = initialBalance;
        transactionActivity = null;
        businessDate = new Date();
    }

    public void depositAmount( double moneyToBeDeposited) {
        this.balance= this.balance + moneyToBeDeposited;
        this.transactionActivity= "Deposit";
    }

    public void withdrawAmount( double moneyToBeWithdrawn) {
        this.balance= this.balance - moneyToBeWithdrawn;
        this.transactionActivity="Withdraw";
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAcctNumber() {
        return acctNumber;
    }

    public void setAcctNumber(String acctNumber) {
        this.acctNumber = acctNumber;
    }

    public void printReport ()
    {
        System.out.println("As of Business Date:" +  businessDate);
        System.out.println("Account Number:" + this.acctNumber);
        System.out.println("Transaction Activity:" +  this.transactionActivity);
        System.out.println("Balance:" +  this.balance);


    }
    public void printBalanceReport ()
    {
        System.out.println("As of Business Date:" +  businessDate);
        System.out.println("Account Number:" + this.acctNumber);
        System.out.println("Balance:" +  this.balance);


    }
    public static void transferFunds(Account fromAccount, Account toAccount,  double transferAmount)
    {
        if (fromAccount.getBalance() >= transferAmount)
        { fromAccount.withdrawAmount(transferAmount);
            toAccount.depositAmount(transferAmount);
        }
    }

}