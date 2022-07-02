package com.example.demo.repositories;

import com.example.demo.models.ObatModels;
import com.example.demo.models.PegawaiModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObatRepository extends JpaRepository<ObatModels, Integer> {
    @Query("FROM ObatModels ")
    public List<ObatModels> getObat();

    @Query(value = "SELECT nama FROM obat", nativeQuery = true)
    public List<String> getNama();

    @Query(value = "SELECT nama FROM kategori", nativeQuery = true)
    public List<String> getNamaKategori();

    @Query(value = "SELECT nama FROM pemasok", nativeQuery = true)
    public List<String> getNamaPemasok();

    @Query(value = "SELECT count(id_obat) FROM obat WHERE stok=0", nativeQuery = true)
    public Integer getEmptyStock();

    @Query(value = "SELECT count(id_obat) FROM obat WHERE stok<10 && stok>0", nativeQuery = true)
    public Integer getMinStock();

    @Query(value = "SELECT count(id_obat) FROM obat WHERE stok>=10", nativeQuery = true)
    public Integer getAyaStock();

    @Query(value = "SELECT sum(stok) FROM obat", nativeQuery = true)
    public Integer getSumStock();

    @Query(value = "SELECT count(id_obat) FROM obat WHERE kedaluwarsa BETWEEN DATE_SUB(NOW(), INTERVAL 40 YEAR) AND NOW()", nativeQuery = true)
    public Integer getCountExpObat();

    @Query(value = "SELECT sum(stok) FROM obat WHERE kedaluwarsa BETWEEN DATE_SUB(NOW(), INTERVAL 40 YEAR) AND NOW()", nativeQuery = true)
    public Integer getSumExpObat();

    @Query(value = "select * from obat where id_obat like %:cariParam% or nama like %:cariParam% or unit like %:cariParam% or stok like %:cariParam% or kategori like %:cariParam% or hargabeli like %:cariParam% or hargajual like %:cariParam% or pemasok like %:cariParam%", nativeQuery = true)
    public List<ObatModels> getObat(@Param("cariParam") String cari);
}
