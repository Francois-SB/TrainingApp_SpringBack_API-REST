package fr.fms.dao;

import fr.fms.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    public AppUser findByUsername(String userName);
}
