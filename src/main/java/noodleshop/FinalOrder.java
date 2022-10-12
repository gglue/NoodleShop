package noodleshop;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FinalOrder {

    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryProv;
    private String deliveryPost;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;

    private List<Noodle> noodles = new ArrayList<>();

    public void addNoodle(Noodle noodle){
        this.noodles.add(noodle);
    }
}
