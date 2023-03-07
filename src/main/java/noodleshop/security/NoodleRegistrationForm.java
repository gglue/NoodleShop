package noodleshop.security;

import noodleshop.NoodleUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.Data;

@Data
public class NoodleRegistrationForm {
    private String username;
    private String password;
    private String fullName;

    public NoodleUser toUser(PasswordEncoder passwordEncoder) {
        return new NoodleUser(username, passwordEncoder.encode(password), 0,
                fullName);
    }
}