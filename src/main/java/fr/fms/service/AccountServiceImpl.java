package fr.fms.service;

import fr.fms.dao.AppRoleRepository;
import fr.fms.dao.AppUserRepository;

import fr.fms.entities.AppRole;
import fr.fms.entities.AppUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    AppRoleRepository appRoleRepository;

    @Autowired
            @Lazy
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public AppRole saveAppRole(AppRole appRole) {
//        log.info("Nouveau role sauvegardé en base");
        return appRoleRepository.save(appRole);
    }

    @Override
    public AppUser saveUser(AppUser appUser) {
        String hashPw = bCryptPasswordEncoder.encode(appUser.getPassword());
        appUser.setPassword(hashPw);
        return appUserRepository.save(appUser);
    }

    @Override
    public AppUser getUserByUsername(String usernmae) {
        return appUserRepository.findByUsername(usernmae);
    }

    @Override
    public AppRole getAppRoleByRolename(String rolename) {
        return appRoleRepository.findByRolename(rolename);
    }

    @Override
    public ResponseEntity<List<AppUser>> getUserList() {
        return ResponseEntity.ok().body(appUserRepository.findAll());
    }

    @Override
    public void AddRoleToUser(String username, String appRolename) {
        AppUser appUser = appUserRepository.findByUsername(username);
        AppRole appRole = appRoleRepository.findByRolename(appRolename);

        appUser.getRoles().add(appRole);
    }
}
