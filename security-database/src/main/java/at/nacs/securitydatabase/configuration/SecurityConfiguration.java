package at.nacs.securitydatabase.configuration;

import at.nacs.securitydatabase.security.UserDetailsServiceImp;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
  private UserDetailsServiceImp userDetailsService;
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(authenticationProvider());
  }
  @Bean
  public DaoAuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
    provider.setUserDetailsService(userDetailsService);
    provider.setPasswordEncoder(passwordEncoder());
    return provider;
  }
  @Bean
   PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
        .anyRequest().fullyAuthenticated()
        .and()
        .formLogin().loginPage("/login").failureForwardUrl("/login?error").permitAll()
        .and()
        .logout().permitAll();
  }
}

