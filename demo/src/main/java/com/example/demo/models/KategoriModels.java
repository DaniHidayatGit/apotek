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
@Table(name = "kategori")
public class KategoriModels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_kat;

    @Column(name = "nama")
    private String nama;

    @Column(name = "keterangan")
    private String keterangan;
}
