package lk.ijse.thogakade_pos_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailsDTO {
    private String orderId;
    private Date orderDate;
    private String customerId;
    private List<ItemDTO> orderItems;
    private double totalPrice;
    private double discount;
    private double subTotal;
}
