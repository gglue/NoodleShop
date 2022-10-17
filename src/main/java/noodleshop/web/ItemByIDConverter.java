package noodleshop.web;


import noodleshop.Item;
import noodleshop.data.ItemRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ItemByIDConverter implements Converter<Long, Item> {
    private ItemRepository itemRepo;

    public ItemByIDConverter(ItemRepository customItemRepo){
        this.itemRepo = itemRepo;
    }

    @Override
    public Item convert(Long id) {
        return itemRepo.findById(id).orElse(null);
    }
}
