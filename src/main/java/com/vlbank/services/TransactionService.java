package com.vlbank.services;

import com.vlbank.domain.Transaction.Transaction;
import com.vlbank.domain.user.User;
import com.vlbank.dtos.TransactionDTO;
import com.vlbank.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.logging.Logger;

@Service
public class TransactionService {

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionRepository transactionRepository;

    private static final Logger logger = Logger.getLogger(TransactionService.class.getName());

    public void createTransaction(TransactionDTO transaction) throws Exception {
        logger.info("ID do remetente: " + transaction.senderId());
        logger.info("ID do destinatário: " + transaction.receiverId());

        User sender = userService.findUserById(transaction.senderId());
        User receiver = userService.findUserById(transaction.receiverId());
        userService.validateTransaction(sender, transaction.value());

        Transaction newTransaction = new Transaction();
        newTransaction.setSender(sender);
        newTransaction.setReceiver(receiver);
        newTransaction.setAmount(transaction.value());
        newTransaction.setTimestamp(LocalDateTime.now());

        sender.setBalance(sender.getBalance().subtract(transaction.value()));
        receiver.setBalance(receiver.getBalance().add(transaction.value()));

        transactionRepository.save(newTransaction);
        userService.saveUser(sender);
        userService.saveUser(receiver);
    }
}
