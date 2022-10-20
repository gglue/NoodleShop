package noodleshop.security;

import noodleshop.NoodleUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.Data;

@Data
public class NoodleRegistrationForm {
    private String username;
    private String password;
    private String fullName;
    private String street;
    private String city;
    private String province;
    private String postal;
    private String phone;

    public NoodleUser toUser(PasswordEncoder passwordEncoder) {
        return new NoodleUser(username, passwordEncoder.encode(password), 0,
                fullName, street, city, province, postal, phone);
    }
}