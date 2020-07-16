package org.xpdojo.bank;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.xpdojo.bank.Account.transferFunds;

public class AccountTest {

    @Test
    public void getBalance() {
        Account account = new Account();
        assertThat(account.getBalance()).isEqualTo(0);
    }

    @Test
    public void depositAmount() {
        Account account = new Account();
        account.depositAmount(50);
        assertThat(account.getBalance()).isEqualTo(50);
    }

    @Test
    public void depositAmountNegative() {
        Account account = new Account();
        account.depositAmount(-50);
        assertThat(account.getBalance()).isEqualTo(0);
    }

    @Test
    public void withdrawAmount() {
        Account account = new Account();
        account.withdrawAmount(50);
        assertThat(account.getBalance()).isEqualTo(-50);
    }

    @Test
    public void transferAmount () {
        Account account = new Account();
        account.depositAmount(20);
        Account targetAccount = new Account();
        targetAccount.depositAmount(5);

        transferFunds(account, targetAccount, 5);

        assertThat(account.getBalance()).isEqualTo(15);
        assertThat(targetAccount.getBalance()).isEqualTo(10);
    }

    @Test
    public void transferAmountFail () {
        Account account = new Account();
        account.depositAmount(20);
        Account targetAccount = new Account();
        targetAccount.depositAmount(5);

        transferFunds(account, targetAccount, 30);

        assertThat(account.getBalance()).isEqualTo(20);
        assertThat(targetAccount.getBalance()).isEqualTo(5);
    }

    @Test
    public void transferNegativeAmount () {
        Account account = new Account();
        account.depositAmount(20);
        Account targetAccount = new Account();
        targetAccount.depositAmount(5);

        transferFunds(account, targetAccount, -5);

        assertThat(account.getBalance()).isEqualTo(20);
        assertThat(targetAccount.getBalance()).isEqualTo(5);
    }

    @Test
    public void transferFullBalanceAmount () {
        Account account = new Account();
        account.depositAmount(20);
        Account targetAccount = new Account();
        targetAccount.depositAmount(5);

        transferFunds(account, targetAccount, 20);

        assertThat(account.getBalance()).isEqualTo(0);
        assertThat(targetAccount.getBalance()).isEqualTo(25);
    }


}