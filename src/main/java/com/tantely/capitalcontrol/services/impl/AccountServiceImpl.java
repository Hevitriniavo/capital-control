package com.tantely.capitalcontrol.services.impl;

import com.tantely.capitalcontrol.dtos.AccountResponse;
import com.tantely.capitalcontrol.dtos.Paginate;
import com.tantely.capitalcontrol.services.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Override
    public Paginate<AccountResponse> findAllAccounts( Integer currentPage, Integer pageNumber) {
        return null;
    }
}
