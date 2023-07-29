package lk.ijse.pos.dto;

import lk.ijse.pos.entity.SuperEntity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CustomerDto implements SuperEntity, SuperDto {
    private int id;
    private String name;
    private String address;
    private double salary;
}
