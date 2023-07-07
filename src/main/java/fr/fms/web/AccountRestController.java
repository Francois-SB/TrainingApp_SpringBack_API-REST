package fr.fms.web;

import fr.fms.entities.AppRole;
import fr.fms.entities.User;
import fr.fms.entities.UserRoleForm;
import fr.fms.service.AccountServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Access;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/account")
public class AccountRestController {
    @Autowired
    AccountServiceImpl accountService;

    @GetMapping("/users")
    ResponseEntity<List<User>> getUsers(){return this.accountService.getUserList();}
    @PostMapping("users")
    public User postUser(@RequestBody User user){ return this.accountService.saveUser(user);}

    @PostMapping("role")
    public AppRole postRole(@RequestBody AppRole appRole){ return this.accountService.saveAppRole(appRole);}

    @PostMapping("/RoleUser")
    public void postRoleToUser(@RequestBody UserRoleForm userRoleForm){
        accountService.AddRoleToUser(userRoleForm.getUsername(),userRoleForm.getRolename());
    }
    @GetMapping("/t")
public String test(){
        return "test OK";
}
}
