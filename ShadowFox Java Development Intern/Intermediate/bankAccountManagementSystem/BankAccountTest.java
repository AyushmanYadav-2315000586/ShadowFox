package bankAccountManagementSystem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;


class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount("Test User", 1000.0);
    }

    @Test
    void testDepositValidAmount() {
        account.deposit(500.0);
        assertEquals(1500.0, account.getBalance());
    }

    @Test
    void testDepositInvalidAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> account.deposit(-100.0));
        assertEquals("Deposit amount must be greater than 0", exception.getMessage());
    }

    @Test
    void testWithdrawValidAmount() {
        account.withdraw(500.0);
        assertEquals(500.0, account.getBalance());
    }

    @Test
    void testWithdrawInvalidAmount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> account.withdraw(-100.0));
        assertEquals("Withdrawal amount must be greater than 0", exception.getMessage());
    }

    @Test
    void testWithdrawInsufficientBalance() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> account.withdraw(2000.0));
        assertEquals("Insufficient balance", exception.getMessage());
    }

    @Test
    void testTransactionHistory() {
        account.deposit(100.0);
        account.withdraw(50.0);
        assertEquals(3, account.getTransactionHistory().size());
    }
}
