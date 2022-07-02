package com.example.demo.dto;

public class ObatDto {
    private Integer id_obat, stok, hargabeli, hargajual;
    private String nama, unit, kategori, pemasok, kedaluwarsa;

    public Integer getId_obat() {
        return id_obat;
    }

    public void setId_obat(Integer id_obat) {
        this.id_obat = id_obat;
    }

    public Integer getStok() {
        return stok;
    }

    public void setStok(Integer stok) {
        this.stok = stok;
    }

    public Integer getHargabeli() {
        return hargabeli;
    }

    public void setHargabeli(Integer hargabeli) {
        this.hargabeli = hargabeli;
    }

    public Integer getHargajual() {
        return hargajual;
    }

    public void setHargajual(Integer hargajual) {
        this.hargajual = hargajual;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getPemasok() {
        return pemasok;
    }

    public void setPemasok(String pemasok) {
        this.pemasok = pemasok;
    }

    public String getKedaluwarsa() {
        return kedaluwarsa;
    }

    public void setKedaluwarsa(String kedaluwarsa) {
        this.kedaluwarsa = kedaluwarsa;
    }
}
