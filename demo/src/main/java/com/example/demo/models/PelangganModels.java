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
@Table(name = "pelanggan")
public class PelangganModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_peg;

    @Column(name = "nama")
    private String nama;

    @Column(name = "jk")
    private String jk;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "nohp")
    private String nohp;

    @Column(name = "email")
    private String email;

    @Column(name = "level")
    private String level;

    @Column(name = "riwayat")
    private Integer riwayat;
}
