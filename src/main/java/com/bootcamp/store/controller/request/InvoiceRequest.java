package com.bootcamp.store.controller.request;

import com.bootcamp.store.model.Product;
import com.bootcamp.store.model.User;
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
    private User userId;
    private List<Product> invoiceWithProducts;
}
