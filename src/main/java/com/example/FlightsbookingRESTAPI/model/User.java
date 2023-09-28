package com.example.FlightsbookingRESTAPI.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.PersistenceConstructor;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;
    
    @Column(name = "phone")
    private String phone;
    

    @Column(name = "reservation")
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Reservation> reservations;


    public User(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public User() {

    }
}
