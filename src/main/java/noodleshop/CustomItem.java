package noodleshop;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class CustomItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int totalPrice;

    @ManyToOne
    private Item item;

    @ManyToMany
    private List<Extra> extras;
}
