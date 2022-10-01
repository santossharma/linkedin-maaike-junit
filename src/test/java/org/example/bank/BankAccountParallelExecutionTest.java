package org.example.bank;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by santoshsharma on 01 Oct, 2022
 *
 * This test class runs in parallel mode
 * @Execution annotation is required with execution mode as Concurrent
 * configuration added in junit-platform.properties
 */

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountParallelExecutionTest {

    @ParameterizedTest
    @ValueSource(ints = {100, 200, 300, 400})
    @DisplayName("Depositing successfully")
    void testDeposit(int amount, BankAccount bankAccount) {
        bankAccount.deposit(amount);
        assertEquals(amount, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Depositing successfully")
    @EnabledOnOs({OS.WINDOWS})
    void testDepositWithSlowness(BankAccount bankAccount) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bankAccount.deposit(500);
        assertEquals(500, bankAccount.getBalance());
    }
}
