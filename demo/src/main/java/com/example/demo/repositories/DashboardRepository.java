package com.example.demo.repositories;

import com.example.demo.models.ObatModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DashboardRepository extends JpaRepository<ObatModels, Integer> {
    @Query(value = "SELECT count(*) FROM pegawai", nativeQuery = true)
    public Integer getCountPegawai();

    @Query(value = "SELECT count(*) FROM pelanggan", nativeQuery = true)
    public Integer getCountPelanggan();

    @Query(value = "SELECT count(*) FROM pemasok", nativeQuery = true)
    public Integer getCountPemasok();

    @Query(value = "SELECT count(*) FROM kategori", nativeQuery = true)
    public Integer getCountKategori();

    @Query(value = "SELECT count(*) FROM Obat", nativeQuery = true)
    public Integer getCountObat();
}
