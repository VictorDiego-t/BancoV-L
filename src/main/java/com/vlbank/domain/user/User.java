package com.vlbank.domain.user;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Vai gerar um Id Automatico
    private long id;

    private String firstName;
    private String lastName;

    @Column(unique = true) // Define a coluna document como unica
    private String document;
    @Column(unique = true)
    private String email;

    private String password;
    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    // Adicionando os métodos getUserType e getBalance
    public UserType getUserType() {
        return userType;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
