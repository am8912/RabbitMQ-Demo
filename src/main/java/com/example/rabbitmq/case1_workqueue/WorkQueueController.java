package com.example.rabbitmq.case1_workqueue;

import com.example.rabbitmq.common.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/case1")
public class WorkQueueController {
    private final AmqpTemplate amqp;

    @PostMapping("/produce")
    public String produce(@RequestBody OrderDto dto) {
        // 直接送進 queue（用 default exchange）
        amqp.convertAndSend(WorkQueueConfig.Q, dto);
        return "queued: " + dto.getOrderId();
    }
}
