package com.wallet.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class WalletServiceTest {
    private WalletService walletService;
    
    @BeforeEach
    void setUp() {
        walletService = new WalletService();
    }
    
    @Test
    void shouldCreateWallet() {
        Wallet wallet = walletService.createWallet("user1");
        assertNotNull(wallet.getId());
        assertEquals(BigDecimal.ZERO, wallet.getBalance());
    }
    
    @Test
    void shouldCreditAmount() {
        Wallet wallet = walletService.createWallet("user1");
        walletService.credit(wallet.getId(), BigDecimal.valueOf(100));
        assertEquals(BigDecimal.valueOf(100), wallet.getBalance());
    }
    
    // Add more tests...
}