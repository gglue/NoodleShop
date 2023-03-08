package noodleshop;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;
@Data
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min=3, message="Please give the item a proper name.")
    private String name;

    @NotNull(message="Please label the type of the item.")
    @ManyToOne
    private ItemType type;

    @NotNull(message="Give it a nice description.")
    private String desc;

    @NotNull
    @Size(min=1, message="Please use a placeholder image.")
    private String image;

    @Min(message="Item show be at least be 1 dollar.", value=100)
    private int price;

}
