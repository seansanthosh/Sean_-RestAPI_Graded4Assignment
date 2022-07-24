package com.greatlearning.empmanagement.event.security;
import com.greatlearning.empmanagement.event.entity.RoleData;
import com.greatlearning.empmanagement.event.entity.UserData;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
public class EmployeeUserDetails implements org.springframework.security.core.userdetails.UserDetails {
    private UserData user;
    public EmployeeUserDetails(UserData user) {
        this.user = user;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<RoleData> roles =  user.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (RoleData role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return authorities;
    }
    @Override
    public String getPassword() {
        return user.getPassword();
    }
    @Override
    public String getUsername() {
        return user.getName();
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}