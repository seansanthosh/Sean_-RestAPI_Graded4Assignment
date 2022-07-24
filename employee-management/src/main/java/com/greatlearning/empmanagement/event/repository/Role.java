package com.greatlearning.empmanagement.event.repository;
import com.greatlearning.empmanagement.event.entity.RoleData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Role extends JpaRepository<RoleData,Long>{
}
