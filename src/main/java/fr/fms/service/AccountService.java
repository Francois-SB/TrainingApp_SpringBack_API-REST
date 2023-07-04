package fr.fms.service;

import fr.fms.entities.AppRole;
import fr.fms.entities.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AccountService {
    public AppRole saveAppRole(AppRole appRole);
    public User saveUser(User user);
    public User getUserByUsername(String username);
    public AppRole getAppRoleByRolename(String rolename);
    public ResponseEntity<List<User>> getUserList();
    public void AddRoleToUser(String username, String appRolename);
}
