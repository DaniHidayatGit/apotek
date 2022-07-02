package com.example.demo.dto;

public class KategoriDto {
    private Integer id_kat;
    private String nama, keterangan;

    public Integer getId_kat() {
        return id_kat;
    }

    public void setId_kat(Integer id_kat) {
        this.id_kat = id_kat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
