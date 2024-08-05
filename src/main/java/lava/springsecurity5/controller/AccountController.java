package lava.springsecurity5.controller;

import lava.springsecurity5.domain.Account;
import lava.springsecurity5.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/account/{role}/{username}/{password}")
    public Account createAccount(@PathVariable String role, @PathVariable String username, @PathVariable String password) {
        Account account = new Account(role, username, password);
        return accountService.createNew(account);
    }
}
