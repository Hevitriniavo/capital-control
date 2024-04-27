package com.tantely.capitalcontrol.controllers;

import com.tantely.capitalcontrol.dtos.AccountResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/accounts")
public class AccountController {

    @GetMapping
    public List<AccountResponse> sayHello() {
        return List.of();
    }
}
