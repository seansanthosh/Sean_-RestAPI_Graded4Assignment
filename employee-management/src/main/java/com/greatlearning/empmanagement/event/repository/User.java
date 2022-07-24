package com.greatlearning.empmanagement.event.repository;
import com.greatlearning.empmanagement.event.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface User extends JpaRepository<UserData,Long> {
	String query1 = "SELECT u FROM User u WHERE u.name = ?1";
    @Query(query1)
    public UserData getUserByUsername(String username);
}
