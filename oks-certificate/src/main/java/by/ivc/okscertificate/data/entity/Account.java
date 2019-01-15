package by.ivc.okscertificate.data.entity;

import java.util.List;

public class Account {

    private Long id;
    private String login;
    private String password;
    private String name;
    private List<Role> roles;

    public Account() {
    }

    public Account(Long id, String login, String password, String name, List<Role> roles) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
