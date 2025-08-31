package com.example.rabbitmq.case1_workqueue;

import com.example.rabbitmq.common.dto.OrderDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class WorkQueueConsumers {

    // 同一 queue 開多個消費者 → 輪詢/公平派發
    @RabbitListener(queues = WorkQueueConfig.Q, concurrency = "3") // 同一JVM起3個consumer
    public void consumeA(OrderDto dto) throws InterruptedException {
        log.info("[C-A] handle {}", dto);
        Thread.sleep(300); // 模擬工作
    }
}
