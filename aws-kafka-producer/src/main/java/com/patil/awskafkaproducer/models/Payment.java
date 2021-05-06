package com.patil.awskafkaproducer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Payment implements Serializable {
    private int id;
    private int userId;
    private int amount;
}
