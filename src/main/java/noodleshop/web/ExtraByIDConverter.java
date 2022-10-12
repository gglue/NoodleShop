package noodleshop.web;

import noodleshop.Extra;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ExtraByIDConverter implements Converter<String, Extra> {

    private Map<String, Extra> extraMap = new HashMap<>();
    public ExtraByIDConverter(){
        extraMap.put("0", new Extra(0,"Extra Noodle", 100));
        extraMap.put("1", new Extra(1,"Extra Soup", 100));
    }

    @Override
    public Extra convert (String id){
        return extraMap.get(id);
    }
}
