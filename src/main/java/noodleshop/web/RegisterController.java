package noodleshop.web;
import lombok.extern.slf4j.Slf4j;
import noodleshop.data.EmployeeRepository;
import noodleshop.security.EmployeeRegistrationForm;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/employeeregister")
public class RegisterController {

    private EmployeeRepository userRepo;
    private PasswordEncoder passwordEncoder;

    public RegisterController(EmployeeRepository userRepo, PasswordEncoder passwordEncoder){
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String registerForm(){
        return "EmployeeRegister";
    }

    @PreAuthorize("hasUser('ADMIN')")
    @PostMapping
    public String processRegistration(EmployeeRegistrationForm form){
        userRepo.save(form.toUser(passwordEncoder));
        return "redirect:/";
    }
}
