package noodleshop;

import lombok.Data;
import java.util.List;
@Data
public class Noodle {
    private String name;
    private String desc;
    private List<Extra> extras;
    private int price;
}
