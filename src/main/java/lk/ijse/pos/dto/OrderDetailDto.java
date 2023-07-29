package lk.ijse.pos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDto implements SuperDto {
    private int id;
    private int qty;
    private OrderDto order;
    private ItemDto item;
}
