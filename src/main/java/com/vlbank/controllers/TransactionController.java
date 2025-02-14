package com.vlbank.controllers;

import com.vlbank.domain.Transaction.Transaction;
import com.vlbank.dtos.TransactionDTO;
import com.vlbank.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/transfer")
    public ResponseEntity<String> createTransaction(@RequestBody TransactionDTO transaction) {
        try {
            transactionService.createTransaction(transaction);
            return ResponseEntity.ok("Transação criada com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

}
