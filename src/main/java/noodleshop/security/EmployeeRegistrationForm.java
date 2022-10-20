package noodleshop.security;

import noodleshop.EmployeeUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.Data;

@Data
public class EmployeeRegistrationForm {
    private String username;
    private String password;

    public EmployeeUser toUser(PasswordEncoder passwordEncoder) {
        return new EmployeeUser(username, passwordEncoder.encode(password));
    }
}