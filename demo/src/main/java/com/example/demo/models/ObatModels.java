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
@Table(name = "obat")
public class ObatModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_obat;

    @Column(name = "nama")
    private String nama;

    @Column(name = "unit")
    private String unit;

    @Column(name = "stok")
    private Integer stok;

    @Column(name = "kategori")
    private String kategori;

    @Column(name = "hargabeli")
    private Integer hargabeli;

    @Column(name = "hargajual")
    private Integer hargajual;

    @Column(name = "pemasok")
    private String pemasok;

    @Column(name = "kedaluwarsa")
    private String kedaluwarsa;
}
