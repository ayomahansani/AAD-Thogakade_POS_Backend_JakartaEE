package lk.ijse.thogakade_pos_backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item implements Serializable {
    private String code;
    private String name;
    private double price;
    private int qty;
}
