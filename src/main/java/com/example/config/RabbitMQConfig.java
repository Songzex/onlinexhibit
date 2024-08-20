package com.example.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME = "exampleQueue";
    public static final String QUEUE_ONE = "exampleQueueOne";
    public static final String EXCHANGE_NAME = "exampleExchange";
    public static final String EXCHANGE_NAME_ONE = "exampleExchange";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME, true);
    }
    @Bean
    public Queue queueOne() {
        return new Queue(QUEUE_ONE, true);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }
    @Bean
    public TopicExchange exchangeOne() {
        return new TopicExchange(EXCHANGE_NAME_ONE);
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("routing.key.#");
    }
    @Bean
    public Binding bindingOne(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("routing.key.#");
    }
}
