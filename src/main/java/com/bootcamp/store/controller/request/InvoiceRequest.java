package com.bootcamp.store.controller.request;

import com.bootcamp.store.model.Invoice;
import com.bootcamp.store.model.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class InvoiceRequest {
    private int number;
    private double total;

    @JsonIgnore
    public Invoice invoiceBuilder(List<Product> products) {
        return Invoice.builder()
                .number(this.getNumber())
                .total(this.getTotal())
                .invoiceWithProducts(products)
                .build();
    }
}
