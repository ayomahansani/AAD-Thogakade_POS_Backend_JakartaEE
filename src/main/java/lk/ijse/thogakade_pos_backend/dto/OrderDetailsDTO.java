package lk.ijse.thogakade_pos_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDetailsDTO {
    private String orderId;
    private LocalDate orderDate;
    private String customerId;
    private List<OrderDTO> orderItems = new ArrayList<>();
    private double totalPrice;
    private double discount;
    private double subTotal;
}
