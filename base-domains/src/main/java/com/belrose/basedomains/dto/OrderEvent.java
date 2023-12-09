package com.belrose.basedomains.dto;

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
public class OrderEvent  implements Serializable {
    private String message;
    private String status;
    private Order order;
}
