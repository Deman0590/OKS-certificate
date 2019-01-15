package by.ivc.okscertificate.service;

import by.ivc.okscertificate.dto.AccountDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface AccountService extends UserDetailsService {

    List<AccountDTO> findAll();

    AccountDTO findById(long id);

    AccountDTO findByName(String name);

    long save(AccountDTO userDTO);

    void delete(Long id);

    void addRole(Long userId, String role);

    void removeRole(Long userId, String role);
}
