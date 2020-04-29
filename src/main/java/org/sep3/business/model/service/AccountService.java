package org.sep3.business.model.service;

import org.sep3.business.model.service.dto.AccountDTO;
import org.sep3.business.model.service.dto.LoginDTO;

public interface AccountService {

    AccountDTO register(LoginDTO dto);
    AccountDTO login(LoginDTO dto);
}