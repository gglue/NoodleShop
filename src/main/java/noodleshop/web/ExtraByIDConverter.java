package noodleshop.web;

import noodleshop.Extra;
import noodleshop.data.ExtraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ExtraByIDConverter implements Converter<Long, Extra> {

    private ExtraRepository extraRepo;

    @Autowired
    public ExtraByIDConverter(ExtraRepository extraRepo){
        this.extraRepo = extraRepo;
    }

    @Override
    public Extra convert (Long id){
        return extraRepo.findById(id).orElse(null);
    }
}
