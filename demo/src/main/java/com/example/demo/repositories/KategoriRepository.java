package com.example.demo.repositories;

import com.example.demo.models.KategoriModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KategoriRepository extends JpaRepository<KategoriModels, Integer> {
    @Query("FROM KategoriModels")
    public List<KategoriModels> getKategori();

    @Query(value = "select * from kategori where id_kat like %:cariParam% or nama like %:cariParam% or keterangan like %:cariParam%", nativeQuery = true)
    public List<KategoriModels> getKategori(@Param("cariParam") String cari);
}
