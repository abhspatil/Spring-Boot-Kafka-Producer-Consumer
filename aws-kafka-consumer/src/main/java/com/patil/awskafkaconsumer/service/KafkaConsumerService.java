package com.patil.awskafkaconsumer.service;

import com.patil.awskafkaconsumer.models.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumerService {

    @KafkaListener(topics = "${spring.kafka.payment-topic}", containerFactory = "kafkaListenerJsonFactory", groupId = "service1")
    public void consume(Payment payment){
        log.info("Payment Info Received :: " + payment.toString());
    }

    @KafkaListener(topics = {"${spring.kafka.string-topic}"}, containerFactory = "kafkaListenerStringFactory", groupId = "service1")
    public void consume(String message) {
        log.info("### -> Consumed message -> {}", message);
    }
}
