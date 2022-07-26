package com.greatlearning.empmanagement.event.security;
import com.greatlearning.empmanagement.event.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{
	 @Bean
	    public UserDetailsService userDetailsService() {
	        return new UserService();
	    }
	    @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	    @Bean
	    public DaoAuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	        authProvider.setUserDetailsService(userDetailsService());
	        authProvider.setPasswordEncoder(passwordEncoder());
	        return authProvider;
	    }
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.authenticationProvider(authenticationProvider());
			PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	    }
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
		 http.authorizeRequests()
				 .antMatchers("/employees/add").hasAuthority("ADMIN")
				 .antMatchers(HttpMethod.DELETE,"/employees/*").hasAuthority("ADMIN")
                 .antMatchers("/roles/*").permitAll()
				 .antMatchers("/users/*").permitAll()
				 .anyRequest().authenticated()
				 .and() .formLogin()
				 .and() .httpBasic().and().cors().and().csrf().disable();
	    }
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(new String[]{"/h2-console/**"});
	}
}
