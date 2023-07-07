package fr.fms.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserAuth implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
//    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<GrantedAuthority> authorities = new ArrayList<>();



    public Collection<GrantedAuthority> getAuthorities(){
        return this.authorities;
    }
}