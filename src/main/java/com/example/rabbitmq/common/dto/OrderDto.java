package com.example.rabbitmq.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor 
@AllArgsConstructor 
@Builder
public class OrderDto {
    private String orderId;
    private int price;       // 例如：2000 / 4000 / 6000
    private String userId;
}
