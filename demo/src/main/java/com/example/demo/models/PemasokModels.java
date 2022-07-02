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
@Table(name = "pemasok")
public class PemasokModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_peg;

    @Column(name = "nama")
    private String nama;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "nohp")
    private String nohp;

    @Column(name = "email")
    private String email;
}
