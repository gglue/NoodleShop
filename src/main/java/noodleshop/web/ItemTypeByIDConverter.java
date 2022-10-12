package noodleshop.web;

import noodleshop.Extra;
import noodleshop.ItemType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ItemTypeByIDConverter implements Converter<String, ItemType> {

    private Map<String, ItemType> itemMap = new HashMap<>();
    public ItemTypeByIDConverter(){
        itemMap.put("0", new ItemType(0,"Noodle"));
        itemMap.put("1", new ItemType(1,"Side"));
        itemMap.put("2", new ItemType(1,"Drink"));
    }

    @Override
    public ItemType convert (String id){
        return itemMap.get(id);
    }
}
