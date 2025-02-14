package com.vlbank.domain.user;

import com.vlbank.dtos.UserDTO;
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
public final class User {

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

    public User(UserDTO data) {
        firstName = data.firstName();
        lastName = data.lastName();
        document = data.document();
        email = data.email();
        password = data.password();
        balance = data.balance();
        userType = UserType.COMMON;
    }



}
