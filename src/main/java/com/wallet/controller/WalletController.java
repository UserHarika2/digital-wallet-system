package com.wallet.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.UUID;

@RestController
@RequestMapping("/api/wallets")
@RequiredArgsConstructor
public class WalletController {
    private final WalletService walletService;
    
    @PostMapping
    public WalletResponse createWallet(@RequestBody CreateWalletRequest request) {
        return walletService.createWallet(request.getUserId());
    }
    
    @GetMapping("/{id}/balance")
    public BalanceResponse getBalance(@PathVariable UUID id) {
        return new BalanceResponse(walletService.getBalance(id));
    }
    
    @PostMapping("/{id}/credit")
    public void credit(@PathVariable UUID id, @RequestBody AmountRequest request) {
        walletService.credit(id, request.getAmount());
    }
}