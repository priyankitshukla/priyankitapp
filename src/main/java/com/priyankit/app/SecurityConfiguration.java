
package com.priyankit.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	  @Autowired
	  UserDetailsService userDS;
	
	  @Autowired
	  public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
		/*authenticationMgr.inMemoryAuthentication()
			.withUser("root")
			.password("root")
			.authorities("ROLE_USER");*/
		
		authenticationMgr
	      .userDetailsService(userDS);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/index").access("hasRole('ROLE_USER')")
			.and()
				.formLogin().loginPage("/login")
				.defaultSuccessUrl("/index")
				.failureUrl("/loginPage?error")
				.usernameParameter("username").passwordParameter("password")				
			.and().logout().logoutSuccessUrl("/loginPage?logout"); 
				

	}
	  @Override
	  protected UserDetailsService userDetailsService() {
	      return userDS;
	  }  

}