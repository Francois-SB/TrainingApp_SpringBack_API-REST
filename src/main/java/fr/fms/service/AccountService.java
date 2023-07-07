package fr.fms.service;

import fr.fms.entities.AppRole;
import fr.fms.entities.AppUser;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AccountService {
    public AppRole saveAppRole(AppRole appRole);
    public AppUser saveUser(AppUser appuser);
    public AppUser getUserByUsername(String username);
    public AppRole getAppRoleByRolename(String rolename);
    public ResponseEntity<List<AppUser>> getUserList();
    public void AddRoleToUser(String username, String appRolename);
}
