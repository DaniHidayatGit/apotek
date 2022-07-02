package com.example.demo.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "admin")
public class AdminModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_adm;

    @Column(name = "nama")
    private String nama;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
}
