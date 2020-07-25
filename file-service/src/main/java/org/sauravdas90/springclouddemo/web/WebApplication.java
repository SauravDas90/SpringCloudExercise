package org.sauravdas90.springclouddemo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@SpringBootApplication
public class WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}
}

class SecurityConfig extends WebSecurityConfigurerAdapter {
/*@Override
protected void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests().antMatchers("/fileoperation/**").hasAnyRole("ADMIN","USER").
	and().formLogin().and().csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	//http.authorizeRequests().mvcMatchers("/fileoperation/**").authenticated().anyRequest();
	//http.antMatcher("/fileoperation").authorizeRequests().anyRequest().authenticated().and().formLogin();
	
	http
    .csrf()
        .disable()
    .authorizeRequests()
        .anyRequest().authenticated()
    .and()
        .httpBasic()
    .and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
}
@Autowired
public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	  auth.inMemoryAuthentication().withUser("saurav").password("das123");
	  auth.inMemoryAuthentication().withUser("ravan").password("ravan123");
	  auth.inMemoryAuthentication().withUser("kans").password("kans123");
}
*/	
	 @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth.inMemoryAuthentication()
	          .withUser("user1").password(passwordEncoder().encode("user1Pass"))
	          .authorities("ROLE_USER");
	    }
	 
	 @Autowired
	 BasicAuthenticationEntryPoint authenticationEntryPoint;
	
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.authorizeRequests()
	          .antMatchers("/zuutest").permitAll()
	          .anyRequest().authenticated()
	          .and()
	          .httpBasic();
	         // .authenticationEntryPoint(authenticationEntryPoint);
	 
	    /*    http.addFilterAfter(new CustomFilter(),
	          BasicAuthenticationFilter.class);*/
	    }
	 
	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	
	    /*@Override
	    protected void configure(AuthenticationManagerBuilder auth)
	      throws Exception {
	        auth
	          .inMemoryAuthentication()
	          .withUser("user")
	          .password("password")
	          .roles("USER");
	    }
	 
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.csrf().disable()
	          .authorizeRequests()
	          .antMatchers("/test").permitAll()
	          .anyRequest()
	          .authenticated()
	          .and()
	          .httpBasic();
	    }*/
}
