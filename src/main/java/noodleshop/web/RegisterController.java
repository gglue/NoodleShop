package noodleshop.web;
import lombok.extern.slf4j.Slf4j;
import noodleshop.data.UserRepository;
import noodleshop.security.NoodleRegistrationForm;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/register")
public class RegisterController {

    private UserRepository userRepo;
    private PasswordEncoder passwordEncoder;

    public RegisterController(UserRepository userRepo, PasswordEncoder passwordEncoder){
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String registerForm(){
        return "register";
    }

    @PostMapping
    public String processRegistration(NoodleRegistrationForm form){
        userRepo.save(form.toUser(passwordEncoder));
        return "redirect:/";
    }
}
