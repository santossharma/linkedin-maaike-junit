package org.example.bank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by santoshsharma on 27 Sep, 2022
 *
 */
@DisplayName("Tests dependency injection through parameterized testing")
@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountDITest {

    @Test
    @DisplayName("Deposit 400 successfully!! BankAccount obj is injected through dependency injection.")
    void testDeposit(BankAccount bankAccount) {
        bankAccount.deposit(500.00);
        assertEquals(500.00, bankAccount.getBalance());
    }

}
