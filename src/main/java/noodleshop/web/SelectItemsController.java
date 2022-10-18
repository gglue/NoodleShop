package noodleshop.web;

import lombok.extern.slf4j.Slf4j;
import noodleshop.*;
import noodleshop.data.CustomItemRepository;
import noodleshop.data.ExtraRepository;
import noodleshop.data.ItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/select")
@SessionAttributes("manualOrder")
public class SelectItemsController {
    private final ExtraRepository extraRepo;
    private final CustomItemRepository customItemRepo;
    private final ItemRepository itemRepo;
    public SelectItemsController(ExtraRepository extraRepo, CustomItemRepository customItemRepo, ItemRepository itemRepo){
        this.extraRepo = extraRepo;
        this.customItemRepo = customItemRepo;
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
    }

    @ModelAttribute
    public void addItemsToModel(Model model) {
        Iterable<Item> items = itemRepo.findAll();
        List<Item> itemList = new ArrayList<>();
        for (Item item : items){
            itemList.add(item);
        }
        model.addAttribute("items", items);
    }
    @ModelAttribute(name = "manualOrder")
    public ManualOrder order() {
        return new ManualOrder();
    }

    @ModelAttribute(name = "customItem")
    public CustomItem customItem() {
        return new CustomItem();
    }

    @GetMapping
    public String showMenuForm() {
        return "menu";
    }

    @PostMapping
    public String processCustomItem(@Valid CustomItem customItem, Errors errors, @ModelAttribute ManualOrder manualOrder) {

        //if (errors.hasErrors()){
        //    log.info("Error.", customItem);
        //    return "menu";
        //}
        customItemRepo.save(customItem);
        customItem.setTotalPrice(customItemRepo.evaluateTotalItemPrice(customItem.getId()));
        manualOrder.addItem(customItem);
        log.info("Processing item: {}", customItem);
        return "menu";
    }
}