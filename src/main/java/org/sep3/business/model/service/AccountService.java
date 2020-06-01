package org.sep3.business.model.service;

import org.sep3.business.model.service.dto.AccountDTO;
import org.sep3.business.model.service.dto.RegisterDTO;
import org.sep3.business.model.service.dto.LoginDTO;

public interface AccountService {

    AccountDTO register(RegisterDTO dto);
    AccountDTO login(LoginDTO dto);
}