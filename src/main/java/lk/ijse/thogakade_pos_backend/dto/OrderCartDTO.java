package lk.ijse.thogakade_pos_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderCartDTO {
    private String code;
    private String name;
    private double price;
    private int qty;
    private double totalPrice;
}
