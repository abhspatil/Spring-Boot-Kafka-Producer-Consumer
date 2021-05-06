package com.patil.awskafkaproducer.services;

import com.patil.awskafkaproducer.models.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class KafkaProducerService<T> {

    @Value("${spring.kafka.string-topic}")
    private String stringTopic;

    @Value("${spring.kafka.payment-topic}")
    private String paymentTopic;

    @Autowired
    private KafkaTemplate<String, String> stringKafkaTemplate;

    @Autowired
    private KafkaTemplate<String, T> paymentKafkaTemplate;

    public void publish(String message) {
        log.info("#### -> Publishing message -> {}", message);
        stringKafkaTemplate.send(stringTopic, message);
    }

    public void publish(T payment) {
        log.info("#### -> Publishing SuperHero :: {}", payment);
        paymentKafkaTemplate.send(paymentTopic, payment);
    }
}
