package com.greatlearning.empmanagement.event.service;
import com.greatlearning.empmanagement.event.repository.User;
import com.greatlearning.empmanagement.event.entity.UserData;
import com.greatlearning.empmanagement.event.security.EmployeeUserDetails;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
public class UserService implements UserDetailsService {
	   @Autowired
	    private User userRepository;
	    @Override
	    public UserDetails loadUserByUsername(String username)
	            throws UsernameNotFoundException {
	    	UserData user = userRepository.getUserByUsername(username);
	        if (user == null) {
	            throw new UsernameNotFoundException("Could not find user");
	        }
	        return new EmployeeUserDetails(user);
	    }
	        public UserData addUser(UserData user){
	            return userRepository.save(user);
	        }
	        public List<UserData> getAllUsers(){
	            return userRepository.findAll();
	        }
	        public void deleteBYId(Long id){
	             userRepository.deleteById(id);
	        }
	    }



