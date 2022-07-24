package com.greatlearning.empmanagement.event.controller;

import com.greatlearning.empmanagement.event.entity.EmployeeData;
import com.greatlearning.empmanagement.event.entity.RoleData;
import com.greatlearning.empmanagement.event.service.EmployeeService;
import com.greatlearning.empmanagement.event.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    private RoleService roleService;

    @GetMapping("/")
    public List<EmployeeData> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    @GetMapping("/{id}")
    public Optional<EmployeeData> getEmployee(@PathVariable Long id){
        return employeeService.getEmployeeByID(id);
    }
    @GetMapping("/getCustomSortedByFirstName")
    public List<EmployeeData> getEmployeesCustomSortedByName(Sort.Direction direction) {
        return employeeService.getEmployeesCustomSortedByFirstName(direction);
    }
    @GetMapping("/search")
    public List<EmployeeData> searchEmployeeByFirstName(String fname){
        return employeeService.searchEmployeeByFirstName(fname);
    }
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteById(id);
    }
    @PostMapping(value = "/add",consumes = {"application/json"})
    public EmployeeData addEmployee(@RequestBody EmployeeData employee){
        return employeeService.addEmployee(employee);
    }
    @PutMapping(value="/update")
    public EmployeeData updateEmployee(@RequestBody EmployeeData employee){
        return employeeService.updateEmployee(employee);
    }
}
