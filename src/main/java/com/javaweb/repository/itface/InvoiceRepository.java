package com.javaweb.repository.itface;

import com.javaweb.entity.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Integer> {
}
