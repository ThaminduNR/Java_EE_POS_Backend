package lk.ijse.pos.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Item implements SuperEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String item_name;
    private int price;
    private int quantity;

    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "item")
    @ToString.Exclude
    private List <OrderDetail> items ;

}
