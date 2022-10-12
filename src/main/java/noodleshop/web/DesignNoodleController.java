package noodleshop.web;

import lombok.extern.slf4j.Slf4j;
import noodleshop.Extra;
import noodleshop.FinalOrder;
import noodleshop.Noodle;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("finalOrder")
public class DesignNoodleController {

    @ModelAttribute
    public void addExtrasToModel(Model model) {
        List<Extra> extras = Arrays.asList(
                new Extra(0,"Extra Noodle", 100),
                new Extra(1,"Extra Soup", 100)
        );
        model.addAttribute("extras", extras);
    }

    @ModelAttribute(name = "finalOrder")
    public FinalOrder order() {
        return new FinalOrder();
    }

    @ModelAttribute(name = "noodle")
    public Noodle noodle() {
        return new Noodle();
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    @PostMapping
    public String processNoodle(Noodle noodle, @ModelAttribute FinalOrder finalOrder) {
        finalOrder.addNoodle(noodle);
        log.info("Processing noodle: {}", noodle);
        return "redirect:/";
    }
}
