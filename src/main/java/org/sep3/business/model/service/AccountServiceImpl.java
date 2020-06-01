package org.sep3.business.model.service;

import lombok.AllArgsConstructor;
import org.sep3.business.model.domain.Account;
import org.sep3.business.model.persistence.AccountRepository;
import org.sep3.business.model.service.dto.AccountDTO;
import org.sep3.business.model.service.dto.RegisterDTO;
import org.sep3.business.model.service.dto.LoginDTO;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private AccountRepository repo;

    @Override
    public AccountDTO register(RegisterDTO dto) {
        Account acc = new Account(dto.getUsername(), dto.getPassword(), dto.getType());
        repo.save(acc);
        return new AccountDTO(acc.getId(), acc.getUsername(), dto.getType());
    }

    @Override
    public AccountDTO login(LoginDTO dto) {
        Account res = repo.findAccountByUsername(dto.getUsername());
        if(res != null && res.getPassword().equals(dto.getPassword()))
            return new AccountDTO(res.getId(), res.getUsername(), res.getType());
        return null;
    }
}
