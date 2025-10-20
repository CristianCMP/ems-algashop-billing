package com.algaworks.algashop.billing.domain.model.credicard;

import lombok.EqualsAndHashCode;

import java.time.OffsetDateTime;
import java.util.UUID;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CreditCard {
    @EqualsAndHashCode.Include
    private UUID id;
    private OffsetDateTime createdAt;
    private UUID customerId;
    private String lastNumber;
    private String brand;
    private Integer expMonth;
    private Integer expYear;
    private String gatewayCode;
}
