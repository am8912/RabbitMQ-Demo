package com.example.rabbitmq.case1_workqueue;

import org.springframework.context.annotation.*;
import org.springframework.amqp.core.*;

@Configuration
public class WorkQueueConfig {
    public static final String Q = "work.q";

    @Bean
    public Queue workQueue() {
        // durable：Broker 重啟仍存在
        return QueueBuilder.durable(Q).build();
    }
}
