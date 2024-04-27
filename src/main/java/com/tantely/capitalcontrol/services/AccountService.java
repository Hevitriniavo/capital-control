package com.tantely.capitalcontrol.services;

import com.tantely.capitalcontrol.dtos.AccountResponse;
import com.tantely.capitalcontrol.dtos.Paginate;

public interface AccountService {
    Paginate<AccountResponse> findAllAccounts( Integer currentPage, Integer pageNumber);
}
