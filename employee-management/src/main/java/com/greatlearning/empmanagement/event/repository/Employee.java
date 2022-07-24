package com.greatlearning.empmanagement.event.repository;
import com.greatlearning.empmanagement.event.entity.EmployeeData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Employee extends JpaRepository<EmployeeData,Long>  {
}
