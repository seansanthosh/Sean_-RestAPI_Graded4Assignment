package com.greatlearning.empmanagement.event.controller;
import com.greatlearning.empmanagement.event.entity.RoleData;
import com.greatlearning.empmanagement.event.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @GetMapping("/")
    public List<RoleData> getAllRoles(){
        return roleService.getAllRoles();
    }
    @PostMapping(value = "/add",consumes = {"application/json"})
    public RoleData addRole(@RequestBody RoleData role){
        return roleService.addRole(role);
    }
}
