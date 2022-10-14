package noodleshop.web;

import lombok.extern.slf4j.Slf4j;
import noodleshop.Extra;
import noodleshop.ManualOrder;
import noodleshop.Item;
import noodleshop.ItemType;
import noodleshop.data.ExtraRepository;
import noodleshop.data.ItemRepository;
import noodleshop.data.TypeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("manualOrder")
public class DesignItemController {

    private final ExtraRepository extraRepo;
    private final TypeRepository typeRepo;
    private final ItemRepository itemRepo;

    public DesignItemController(ExtraRepository extraRepo, TypeRepository typeRepo, ItemRepository itemRepo){
        this.extraRepo = extraRepo;
        this.typeRepo = typeRepo;
        this.itemRepo = itemRepo;
    }

    @ModelAttribute
    public void addExtrasToModel(Model model) {
        Iterable<Extra> extras = extraRepo.findAll();
        List<Extra> extraList = new ArrayList<>();
        for (Extra extra : extras){
            extraList.add(extra);
        }
        model.addAttribute("extras", extras);

        Iterable<ItemType> itemTypes = typeRepo.findAll();
        List<ItemType> itemList = new ArrayList<>();
        for (ItemType itemType: itemTypes){
            itemList.add(itemType);
        }
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
        itemRepo.save(item);
        log.info("Processing item: {}", item);
        return "redirect:/orders/current";
    }
}
