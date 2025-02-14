package com.vlbank.dtos;

import com.vlbank.domain.user.User;

import java.math.BigDecimal;

public record TransactionDTO(BigDecimal value, long senderId, long receiverId) {



}
