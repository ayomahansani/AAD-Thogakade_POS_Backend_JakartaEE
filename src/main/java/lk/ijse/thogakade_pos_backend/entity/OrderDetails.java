package lk.ijse.thogakade_pos_backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetails {
    private String orderId;
    private Date orderDate;
    private String customerId;
    private double totalPrice;
    private double discount;
    private double subTotal;
}
