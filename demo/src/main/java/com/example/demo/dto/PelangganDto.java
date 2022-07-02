package com.example.demo.dto;

public class PelangganDto {
    private Integer id_peg, riwayat;
    private String nama, jk, alamat, nohp, email, level;

    public Integer getId_peg() {
        return id_peg;
    }

    public void setId_peg(Integer id_peg) {
        this.id_peg = id_peg;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNohp() {
        return nohp;
    }

    public void setNohp(String nohp) {
        this.nohp = nohp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getRiwayat() {
        return riwayat;
    }

    public void setRiwayat(Integer riwayat) {
        this.riwayat = riwayat;
    }
}
