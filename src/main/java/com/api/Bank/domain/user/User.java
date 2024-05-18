package com.api.Bank.domain.user;

import com.api.Bank.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String document;

    @Column(unique = true)
    private String email;

    private String password;

    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    public User(UserDTO data){

        this.firstName = data.firstname();
        this.lastName = data.lastname();
        this.document = data.document();
        this.email = data.email();
        this.balance = data.balance();
        this.password = data.password();

    }

}
