package com.greatlearning.empmanagement.event.service;

import com.greatlearning.empmanagement.event.repository.Role;
import com.greatlearning.empmanagement.event.entity.RoleData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleService {
    @Autowired
    private Role roleRepository;
    public RoleData addRole(RoleData role){

        return roleRepository.save(role);
    }
    public List<RoleData> getAllRoles(){
        return roleRepository.findAll();
    }

}
