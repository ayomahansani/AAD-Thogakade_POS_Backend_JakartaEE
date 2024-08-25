package lk.ijse.thogakade_pos_backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderCart {
    private String code;
    private String name;
    private double price;
    private int qty;
    private double totalPrice;
}
