package com.banking.banking.dto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AccountDto {

    private final Long id;
    private final String accountHolderName;
    private final Double balance;

    public AccountDto(Long id, String accountHolderName, Double balance) {
        this.id = id;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }



    public Long getId() {
        return id;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public Double getBalance() {
        return balance;
    }
}

//    public AccountDto(Long id, String accountHolderName, Double balance) {
//    }
//
//
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Object id) {
//        this.id = (Long) id;
//    }
//
//    public String getAccountHolderName() {
//        return accountHolderName;
//    }
//
//    public void setAccountHolderName(Object accountHolderName) {
//        this.accountHolderName = (String) accountHolderName;
//    }
//
//    public Double getBalance() {
//        return balance;
//    }
//
//    public void setBalance(Object balance) {
//        this.balance = (double) balance;
//    }
//}
//
