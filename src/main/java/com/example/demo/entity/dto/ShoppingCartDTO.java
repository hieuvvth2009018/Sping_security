package com.example.demo.entity.dto;

import com.example.demo.search.ShoppingCart;
import lombok.*;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShoppingCartDTO {
    private String id;
    private String userId; // ai tạo
    private BigDecimal totalPrice;
    private String shipName;
    private String shipAddress;
    private String shipPhone;
    private String shipNote;
    private Set<com.example.demo.entity.dto.CartItemDTO> items;

    public ShoppingCart generateCart(){
        return new ShoppingCart();
    }
}
