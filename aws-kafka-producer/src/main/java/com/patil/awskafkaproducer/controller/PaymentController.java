package com.patil.awskafkaproducer.controller;

import com.patil.awskafkaproducer.models.Payment;
import com.patil.awskafkaproducer.services.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class PaymentController {

    @Autowired
    private KafkaProducerService<Payment> kafkaProducerService;

    @PostMapping("/publish")
    public ResponseEntity<Object> pay(@RequestBody Payment payment){
        kafkaProducerService.publish(payment);
        return ResponseEntity.ok().body("Published!");
    }

    @GetMapping("/publish")
    public ResponseEntity<Object> send(@RequestParam("message") String message){
        kafkaProducerService.publish(message);
        return ResponseEntity.ok().body("Published!");
    }
}
