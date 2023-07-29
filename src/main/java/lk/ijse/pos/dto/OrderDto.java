package lk.ijse.pos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto implements SuperDto{
    private int id;
    private double total;
    private int quantity;
    private Date date;
    private CustomerDto customer;

}
