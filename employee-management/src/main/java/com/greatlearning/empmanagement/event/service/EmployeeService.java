package com.greatlearning.empmanagement.event.service;
import com.greatlearning.empmanagement.event.repository.Employee;
import com.greatlearning.empmanagement.event.entity.EmployeeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class EmployeeService {
    @Autowired
    private Employee employeeRepository;

    public EmployeeData addEmployee(EmployeeData employee){
        return employeeRepository.save(employee);
    }
    public List<EmployeeData> getAllEmployees(){
        return employeeRepository.findAll();
    }
    public void deleteById(long id){
        employeeRepository.deleteById(id);
    }
    public Optional<EmployeeData> getEmployeeByID(long id){
        return employeeRepository.findById(id);
    }
    public EmployeeData updateEmployee(EmployeeData employee){
        return employeeRepository.save(employee);
    }
    public List<EmployeeData> getEmployeesCustomSortedByFirstName(Sort.Direction direction) {
         return employeeRepository.findAll(Sort.by(direction, "firstName"));
    }
   public List<EmployeeData> searchEmployeeByFirstName(String fName){
    	EmployeeData demoEmployee = new EmployeeData();
        demoEmployee.setFirstName(fName);
        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withMatcher("firstName", ExampleMatcher.GenericPropertyMatchers.exact()).withIgnorePaths("id", "lastName","email");
        Example<EmployeeData> example = Example.of(demoEmployee, exampleMatcher);
        return employeeRepository.findAll(example);
    }
}
