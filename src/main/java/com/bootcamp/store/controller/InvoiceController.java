package com.bootcamp.store.controller;

import com.bootcamp.store.controller.request.CreateInvoiceRequest;
import com.bootcamp.store.controller.response.InvoiceResponse;
import com.bootcamp.store.model.Invoice;
import com.bootcamp.store.service.InvoiceService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class InvoiceController {
    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    public List<InvoiceResponse> invoiceResponses(List<Invoice> invoices) {
        List<InvoiceResponse> invoiceResponses = new ArrayList<>();
        for (Invoice invoice : invoices) {
            invoiceResponses.add(invoice.createInvoiceResponse());
        }
        return invoiceResponses;
    }

    //get all invoices
    @GetMapping("/invoices")
    public List<InvoiceResponse> getAllInvoices() {
        return this.invoiceResponses(invoiceService.getAllInvoices());
    }

    //find by id
    @GetMapping("/invoice/{id}")
    public InvoiceResponse getInvoiceById(@PathVariable(value = "id") Long id) {
        return invoiceService.getInvoiceById(id).createInvoiceResponse();
    }

    //create invoice
    @PostMapping(value = "/invoice", consumes = "application/json")
    public InvoiceResponse createInvoice(@RequestBody CreateInvoiceRequest createInvoiceRequest) {
        return invoiceService.createInvoice(createInvoiceRequest.getUserId(), createInvoiceRequest.getProductIdList()).createInvoiceResponse();
    }

}
