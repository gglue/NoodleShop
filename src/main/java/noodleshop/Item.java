package noodleshop;

import lombok.Data;
import java.util.List;
@Data
public class Item {
    private String name;
    private ItemType type;
    private String desc;
    private List<Extra> extras;
    private int price;

}
