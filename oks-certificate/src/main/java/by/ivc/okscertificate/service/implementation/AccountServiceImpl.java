package by.ivc.okscertificate.service.implementation;

import by.ivc.okscertificate.data.entity.Account;
import by.ivc.okscertificate.data.entity.Role;
import by.ivc.okscertificate.data.mapper.AccountMapper;
import by.ivc.okscertificate.dto.AccountDTO;
import by.ivc.okscertificate.dto.mapper.BaseMapper;
import by.ivc.okscertificate.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AccountServiceImpl implements AccountService {

    private final BaseMapper baseMapper;
    private final AccountMapper accountMapper;

    @Autowired
    public AccountServiceImpl(BaseMapper baseMapper, AccountMapper accountMapper) {
        this.baseMapper = baseMapper;
        this.accountMapper = accountMapper;
    }

    @Override
    public List<AccountDTO> findAll() {
        return baseMapper.mapAll(accountMapper.readAll(), AccountDTO.class);
    }

    @Override
    public AccountDTO findById(long id) {
        return baseMapper.map(accountMapper.readById(id), AccountDTO.class);
    }

    @Override
    public AccountDTO findByName(String name) {
        Account user = accountMapper.readByName(name);
        return baseMapper.map(accountMapper.readByName(name), AccountDTO.class);
    }

    @Override
    public long save(AccountDTO userDTO) {
        Account user = baseMapper.map(userDTO, Account.class);
        if (null == user.getId()) {
            accountMapper.create(user);
            for (Role role : userDTO.getRoles()) {
                accountMapper.addRole(user.getId(), role.toString());
            }
        } else {
            accountMapper.update(user);
        }
        return user.getId();
    }

    @Override
    public void delete(Long id) {
        accountMapper.delete(id);
    }

    @Override
    public void addRole(Long userId, String role) {
        accountMapper.addRole(userId, role);
    }

    @Override
    public void removeRole(Long userId, String role) {
        accountMapper.removeRole(userId, role);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountMapper.readByName(username);
//        Account account = new Account();
//        account.setName("ivc");
//        account.setLogin("ivc");
//        //account.setPassword("oks");
//        account.setPassword("$2a$10$/wcaYsgu2fnv9YG2SlnZCeyjrb9FDIhhS9n3EHkXixmxpzPr/haIu");
//        List<Role> roles = new ArrayList<>();
//        roles.add(Role.SUPER_ADMIN);
//        roles.add(Role.ADMIN);
//        account.setRoles(roles);
        if (null == account) {
            throw new UsernameNotFoundException("Username not found");
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : account.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.toString()));
        }
        return new User(account.getLogin(), account.getPassword(), grantedAuthorities);
    }
}
