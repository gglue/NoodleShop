package noodleshop.web;

import lombok.extern.slf4j.Slf4j;
import noodleshop.Extra;
import noodleshop.ManualOrder;
import noodleshop.Item;
import noodleshop.ItemType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("manualOrder")
public class DesignItemController {

    @ModelAttribute
    public void addExtrasToModel(Model model) {
        List<Extra> extras = Arrays.asList(
                new Extra(0,"Extra Noodle", 100),
                new Extra(1,"Extra Soup", 100)
        );
        model.addAttribute("extras", extras);

        List<ItemType> itemTypes = Arrays.asList(
                new ItemType(0,"Noodle"),
                new ItemType(1,"Side"),
                new ItemType(2,"Drink")
        );
        model.addAttribute("itemTypes", itemTypes);
    }

    @ModelAttribute(name = "manualOrder")
    public ManualOrder order() {
        return new ManualOrder();
    }

    @ModelAttribute(name = "item")
    public Item item() {
        return new Item();
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    @PostMapping
    public String processItem(@Valid Item item, Errors errors, @ModelAttribute ManualOrder manualOrder) {

        if (errors.hasErrors()){
            return "design";
        }

        manualOrder.addItem(item);
        log.info("Processing item: {}", item);
        return "redirect:/orders/current";
    }
}
