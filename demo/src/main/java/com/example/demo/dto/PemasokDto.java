package com.example.demo.dto;

public class PemasokDto {
    private Integer id_peg;
    private String nama, alamat, nohp, email;

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
}
