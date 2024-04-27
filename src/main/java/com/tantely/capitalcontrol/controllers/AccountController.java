package com.tantely.capitalcontrol.controllers;

import com.tantely.capitalcontrol.dtos.AccountResponse;
import com.tantely.capitalcontrol.dtos.Paginate;
import com.tantely.capitalcontrol.services.AccountService;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public Paginate<AccountResponse> getAllProducts(
            @RequestParam(required = false , defaultValue = "0") Integer currentPage,
            @RequestParam(required = false, defaultValue = "10") Integer pageNumber
    ) {
        return accountService.findAllAccounts(currentPage, pageNumber);
    }
}
