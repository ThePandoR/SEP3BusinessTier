package org.sep3.business.controller;

import lombok.AllArgsConstructor;
import org.sep3.business.model.service.AccountService;
import org.sep3.business.model.service.dto.AccountDTO;
import org.sep3.business.model.service.dto.RegisterDTO;
import org.sep3.business.model.service.dto.LoginDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
@AllArgsConstructor
public class AccountController {

    private AccountService accountService;

    @PostMapping("/register")
    public ResponseEntity<AccountDTO> register(@RequestBody RegisterDTO dto){
        AccountDTO res = accountService.register(dto);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO dto){
        AccountDTO res = accountService.login(dto);
        if(res == null)
            return new ResponseEntity<>("Unauthorized", HttpStatus.UNAUTHORIZED);
        return ResponseEntity.ok(res);
    }
}
