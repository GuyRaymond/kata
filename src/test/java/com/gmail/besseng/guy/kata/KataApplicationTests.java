package com.gmail.besseng.guy.kata;

import com.gmail.besseng.guy.kata.model.Account;
import com.gmail.besseng.guy.kata.model.User;
import com.gmail.besseng.guy.kata.model.Transaction;
import com.gmail.besseng.guy.kata.exception.TransactionException;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class KataApplicationTests {
    @Test
    @DisplayName("Check if the name of the user is correct")
    public void checkUserHasCorrectName() {
        assertEquals("Claire", (new User("Claire")).getName());
        assertEquals("Guy", (new User("Guy")).getName());
    }
    @Test
    @DisplayName("Check if an user has no account at the beginning")
    public void checkUserHasNoAccount() {
        assertTrue((new User("Claire")).getAccounts().isEmpty());
        assertTrue((new User("Guy")).getAccounts().isEmpty());
        assertTrue((new User()).getAccounts().isEmpty());
    }
    @Test
    @DisplayName("Check if the balance is zero at the opening of an account")
    public void checkBalanceIsZero() {
        assertEquals(0, (new Account()).getBalance().compareTo(BigDecimal.ZERO));
    }
    @Test
    @DisplayName("Check if an account has no transaction at the opening")
    public void checkAccountHasNoTransaction() {
        assertTrue((new Account()).getTransactions().isEmpty());
    }
    @Test
    @DisplayName("Check you can instantiate a transaction with only a positive amount")
    public void checkTransactionAmountPositiveInstantiation() throws TransactionException {
        assertThrows(TransactionException.class, () -> new Transaction(BigDecimal.ZERO, true));
        assertThrows(TransactionException.class, () -> new Transaction(BigDecimal.ZERO, false));
        assertThrows(TransactionException.class, () -> new Transaction(new BigDecimal("-1"), true));
        assertThrows(TransactionException.class, () -> new Transaction(new BigDecimal("-1"), false));
    }
    @Test
    @DisplayName("Check amount is positive for deposit")
    public void checkTransactionAmountPositiveForDeposit() throws TransactionException {
        assertTrue(0 < (new Transaction(new BigDecimal("1000"), true)).getAmount().compareTo(BigDecimal.ZERO));
    }
    @Test
    @DisplayName("Check amount is negative for withdrawal")
    public void checkTransactionAmountNegativeForWithdrawal() throws TransactionException {
        assertTrue((new Transaction(new BigDecimal("1000"), false)).getAmount().compareTo(BigDecimal.ZERO) < 0);
    }
	@Test
	void contextLoads() {
	}
}
