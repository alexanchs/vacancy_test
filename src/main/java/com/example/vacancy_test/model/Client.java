package com.example.vacancy_test.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * @author Ukrainsky Alex.
 */
@Entity
@Table(name = "client", schema = "public")
@Data
@NoArgsConstructor
@ToString
public class Client {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "fio")
    private String fio;

    @OneToMany
    private List<Contact> contactList;

    public Client(String fio) {
        this.fio = fio;
    }
}
