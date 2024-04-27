package com.tantely.capitalcontrol.mappers;

import com.tantely.capitalcontrol.dtos.AccountResponse;
import com.tantely.capitalcontrol.dtos.requests.AccountRequest;
import com.tantely.capitalcontrol.entities.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public Account toAccount(AccountRequest accountRequest){
        return null;
    }

    public AccountResponse fromAccount(Account account){
        return null;
    }
}
