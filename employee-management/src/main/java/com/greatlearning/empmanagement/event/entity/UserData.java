package com.greatlearning.empmanagement.event.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
@SequenceGenerator(name="User_SEQ", sequenceName="user_sequence",allocationSize = 1)
public class UserData {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="User_SEQ")
    private Long id;
    private String name;
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST , CascadeType.REFRESH , CascadeType.DETACH} , fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<RoleData> roles;
    private String password;
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    public void setPassword(final String password) {
        this.password = passwordEncoder().encode(password);
    }
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public List<RoleData> getRoles() {
		return roles;
	}
}
