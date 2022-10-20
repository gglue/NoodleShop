package noodleshop.security;
import noodleshop.EmployeeUser;
import noodleshop.data.EmployeeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig  {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public UserDetailsService userDetailsService(EmployeeRepository employeeRepo) {
        return username -> {
            EmployeeUser user = employeeRepo.findByUsername(username);
            if (user != null) return user;
            throw new UsernameNotFoundException("User '" + username + "' not found");
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeRequests()
                .antMatchers("/design/**", "/h2-console/**").access("hasRole('ADMIN')")
                .antMatchers("/orders/**", "/select/**").access("hasAnyRole('ADMIN','USER')")
                .antMatchers("/", "/**").access("permitAll()")
                .and().headers().frameOptions().sameOrigin()
                .and().formLogin()
                .and().csrf().disable()
                .build();
    }
}
