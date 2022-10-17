package noodleshop;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@Table
public class ManualOrder {

    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    private Date placedAt;
    @NotBlank(message="Delivery name is required")
    private String deliveryName;

    @NotBlank(message="Street is required")
    private String deliveryStreet;

    @NotBlank(message="City is required")
    private String deliveryCity;

    @NotBlank(message="Province is required")
    private String deliveryProv;

    @NotBlank(message="Postal code is required")
    private String deliveryPost;

    //@CreditCardNumber(message="Not a valid credit card number")
    private String ccNumber;

    //@Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$", message="Must be formatted MM/YY")
    private String ccExpiration;

    @Digits(integer=3, fraction=0, message="Invalid CVV")
    private String ccCVV;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CustomItem> items = new ArrayList<>();

    public void addItem(CustomItem item){
        this.items.add(item);
    }
}
