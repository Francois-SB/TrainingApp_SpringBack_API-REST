package fr.fms.service;

import fr.fms.dao.AppRoleRepository;
import fr.fms.dao.UserRepository;
import fr.fms.entities.AppRole;
import fr.fms.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    UserRepository userRepository;

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
    public User saveUser(User user) {
        String hashPw = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(hashPw);
        return userRepository.save(user);
    }

    @Override
    public User getUserByUsername(String usernmae) {
        return userRepository.findByUsername(usernmae);
    }

    @Override
    public AppRole getAppRoleByRolename(String rolename) {
        return appRoleRepository.findByRolename(rolename);
    }

    @Override
    public ResponseEntity<List<User>> getUserList() {
        return ResponseEntity.ok().body(userRepository.findAll());
    }

    @Override
    public void AddRoleToUser(String username, String appRolename) {
        User user = userRepository.findByUsername(username);
        AppRole appRole = appRoleRepository.findByRolename(appRolename);

        user.getRoles().add(appRole);
    }
}
