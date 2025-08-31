package com.example.rabbitmq.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.*;
import org.springframework.context.annotation.*;

/**
 * RabbitTemplate / Listener 共用的 JSON 轉換器
 */
@Configuration
public class RabbitJsonConfig {

    // 給 RabbitTemplate / Listener 共用的 JSON 轉換器
    @Bean
    public MessageConverter jacksonMessageConverter(ObjectMapper mapper) {
        return new Jackson2JsonMessageConverter(mapper);
    }

    // 明確把 converter 掛到 RabbitTemplate（避免仍用到 SimpleMessageConverter）
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory cf, MessageConverter mc) {
        RabbitTemplate tpl = new RabbitTemplate(cf);
        tpl.setMessageConverter(mc);
        return tpl;
    }
}
