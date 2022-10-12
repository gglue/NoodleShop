package noodleshop;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class ManualOrder {

    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryProv;
    private String deliveryPost;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;

    private List<Item> items = new ArrayList<>();

    public void addItem(Item item){
        this.items.add(item);
    }
}
