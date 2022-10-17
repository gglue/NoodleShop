package noodleshop;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;
@Data
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min=3, message="Please give the item a proper name.")
    private String name;

    @NotNull(message="Please label the type of the item.")
    @ManyToOne
    private ItemType type;

    private String desc;

    @Min(message="Item show be at least be 1 dollar.", value=100)
    private int price;

}
