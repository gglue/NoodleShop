package noodleshop.security;

import noodleshop.CustomerUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.Data;

@Data
public class CustomerRegistrationForm {
    private String username;
    private String password;
    private String fullName;
    private String street;
    private String city;
    private String province;
    private String postal;
    private String phone;

    public CustomerUser toUser(PasswordEncoder passwordEncoder) {
        return new CustomerUser(
                username, passwordEncoder.encode(password),
                fullName, street, city, province, postal, phone);
    }
}