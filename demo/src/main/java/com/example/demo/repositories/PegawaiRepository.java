package com.example.demo.repositories;

import com.example.demo.models.PegawaiModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PegawaiRepository extends JpaRepository<PegawaiModels, Integer> {
    @Query("FROM PegawaiModels")
    public List<PegawaiModels> getPegawai();

    @Query(value = "select * from pegawai where id_peg like %:cariParam% or nama like %:cariParam% or jk like %:cariParam% or alamat like %:cariParam% or nohp like %:cariParam% or email like %:cariParam% or status like %:cariParam%", nativeQuery = true)
    public List<PegawaiModels> getPegawai(@Param("cariParam") String cari);
}
