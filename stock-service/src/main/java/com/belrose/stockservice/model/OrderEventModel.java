package com.belrose.stockservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Class used to transport data between Producer and Consumer via kafka broker
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class OrderEventModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="messageValue")
    private String message;
    @Column(name="statusValue")
    private String status;
    @Column(name="orderValue")
    private String order;
}
