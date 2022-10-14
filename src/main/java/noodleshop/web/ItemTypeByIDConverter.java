package noodleshop.web;

import noodleshop.ItemType;
import noodleshop.data.TypeRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class ItemTypeByIDConverter implements Converter<Long, ItemType> {

    private TypeRepository typeRepo;
    public ItemTypeByIDConverter(TypeRepository typeRepo){this.typeRepo = typeRepo;}

    @Override
    public ItemType convert (Long id){
        return typeRepo.findById(id).orElse(null);
    }
}
