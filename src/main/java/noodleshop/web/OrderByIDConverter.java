package noodleshop.web;


import noodleshop.ManualOrder;
import noodleshop.data.OrderRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class OrderByIDConverter implements Converter<Long, ManualOrder> {
    private OrderRepository orderRepo;

    public OrderByIDConverter(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Override
    public ManualOrder convert (Long id){return orderRepo.findById(id).orElse(null);}
}
