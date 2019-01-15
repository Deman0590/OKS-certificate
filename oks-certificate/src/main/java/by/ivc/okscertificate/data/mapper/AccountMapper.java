package by.ivc.okscertificate.data.mapper;

import by.ivc.okscertificate.data.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AccountMapper extends CrudMapper<Long, Account> {

    Account readById(Long id);

    Account readByName(String name);

    List<Account> readAll();

    void addRole(@Param("user") Long userId, @Param("role") String role);

    void removeRole(@Param("user") Long userId, @Param("role") String role);
}
