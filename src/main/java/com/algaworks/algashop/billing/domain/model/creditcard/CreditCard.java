package com.algaworks.algashop.billing.domain.model.creditcard;

import com.algaworks.algashop.billing.domain.model.IdGenerator;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

@Setter(AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class CreditCard {

    @Id
    @EqualsAndHashCode.Include
    private UUID id;
    private OffsetDateTime createdAt;
    private UUID customerId;
    private String lastNumber;
    private String brand;
    private Integer expMonth;
    private Integer expYear;

    private String gatewayCode;

    public static CreditCard brandNew(UUID customerId,
                                      String lastNumber,
                                      String brand,
                                      Integer expMonth,
                                      Integer expYear,
                                      String gatewayCode) {
        Objects.requireNonNull(customerId, "customerId cannot be null");
        Objects.requireNonNull(expMonth, "expMonth cannot be null");
        Objects.requireNonNull(expYear, "expYear cannot be null");

        if (StringUtils.isAnyBlank(lastNumber, brand, gatewayCode)) {
            throw new IllegalArgumentException("lastNumber or brand or gatewayCode cannot be blank");
        }

        return new CreditCard(
                IdGenerator.generateTimeBasedUUID(),
                OffsetDateTime.now(),
                customerId,
                lastNumber,
                brand,
                expMonth,
                expYear,
                gatewayCode
        );
    }

    public void setGatewayCode(String gatewayCode) {
        if (StringUtils.isBlank(gatewayCode)) {
            throw new IllegalArgumentException("gatewayCode cannot be blank");
        }
        this.gatewayCode = gatewayCode;
    }
}
