package noodleshop.web;

import lombok.extern.slf4j.Slf4j;
import noodleshop.ManualOrder;
import noodleshop.data.OrderRepository;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("list")
public class AllOrdersController {

    private final OrderRepository orderRepo;

    public AllOrdersController(OrderRepository orderRepo) {this.orderRepo = orderRepo;}

    @ModelAttribute
    public void addItemsToModel(Model model) {
        Iterable<ManualOrder> orders = orderRepo.findAll(Sort.by(Sort.Direction.DESC, "placedAt"));
        List<ManualOrder> orderList = new ArrayList<>();
        for (ManualOrder order : orders){
            orderList.add(order);
        }
        model.addAttribute("listOrders", orders);
    }

    @ModelAttribute(name = "oneOrder")
    public ManualOrder order() {
        return new ManualOrder();
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String showAllOrders(){
        return "allOrders";
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String showSpecificOrder(@PathVariable String id, Model model){
        ManualOrder specificOrder = orderRepo.findById(Long.parseLong(id)).get();
        model.addAttribute("thatOrder", specificOrder);
        return "specificOrder";
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String processManualOrder(@RequestParam String status, @RequestParam String orderID){
        ManualOrder tempOrder = orderRepo.findById(Long.parseLong(orderID)).get();
        tempOrder.setStatus(Integer.parseInt(status));
        orderRepo.save(tempOrder);
        System.out.printf("OrderID: %s changed status to", orderID);
        System.out.printf("New status: %s \n", status);
        return "allOrders";
    }
}
