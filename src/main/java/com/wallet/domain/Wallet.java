package com.wallet.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    private String userId;
    private BigDecimal balance;
    
    public Wallet(String userId) {
        this.userId = userId;
        this.balance = BigDecimal.ZERO;
    }
    
    public void credit(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }
    
    public void debit(BigDecimal amount) {
        if (this.balance.compareTo(amount) < 0) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        this.balance = this.balance.subtract(amount);
    }
}