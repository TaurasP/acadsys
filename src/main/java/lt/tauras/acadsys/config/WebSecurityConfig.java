package lt.tauras.acadsys.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    public WebSecurityConfig(AuthenticationSuccessHandler authenticationSuccessHandler) {
        this.authenticationSuccessHandler = authenticationSuccessHandler;
    }

    @Autowired
    UserDetailsService userDetailsService;

    // UPGRADE --> ENCODE PASSWORDS
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers( "/css/**").permitAll()
                //.antMatchers("/admin").hasRole("ADMIN")
                //.antMatchers("/showNewUserForm").hasRole("ADMIN")
                .antMatchers("/students").hasRole("ADMIN")
                .antMatchers("/lecturers").hasRole("ADMIN")
                .antMatchers("/courses").hasRole("ADMIN")
                .antMatchers("/groups").hasRole("ADMIN")
                .antMatchers("/index").hasAnyRole("ADMIN", "LECTURER", "STUDENT")
                .antMatchers("/lecturer").hasAnyRole("ADMIN", "LECTURER")
                .antMatchers("/student").hasAnyRole("ADMIN", "STUDENT")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .successHandler(authenticationSuccessHandler)
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and().csrf().disable(); // we'll enable this in a later blog post
    }
}
