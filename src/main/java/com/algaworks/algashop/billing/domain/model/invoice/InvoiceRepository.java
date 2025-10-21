package com.algaworks.algashop.billing.domain.model.invoice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    boolean existsByOrderId(String orderId);
}
