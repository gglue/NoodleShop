package noodleshop.web;

import noodleshop.CustomItem;
import noodleshop.ManualOrder;
import lombok.extern.slf4j.Slf4j;
import noodleshop.NoodleUser;
import noodleshop.data.OrderRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.validation.Errors;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("manualOrder")
public class OrderController {

    private final OrderRepository orderRepo;

    public OrderController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @GetMapping("/current")
    public String orderForm(){
        return "orderForm";
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public String processOrder(@Valid ManualOrder order, Errors errors, SessionStatus sessionStatus, @AuthenticationPrincipal NoodleUser user) {

        if (errors.hasErrors()){
            return "orderForm";
        }
        order.setUser(user);
        orderRepo.save(order);
        for (CustomItem item : order.getItems()){
            item.setOrderID(order.getId());
        }
        orderRepo.save(order);

        log.info("Order submitted: {}", order);
        sessionStatus.setComplete();
        return "redirect:/list";
    }
}
