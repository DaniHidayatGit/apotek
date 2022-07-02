package com.example.demo.repositories;

import com.example.demo.models.PelangganModels;
import com.example.demo.models.PemasokModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PemasokRepository extends JpaRepository<PemasokModels, Integer> {
    @Query("FROM PemasokModels")
    public List<PemasokModels> getPemasok();

    @Query(value = "select * from pemasok where id_peg like %:cariParam% or nama like %:cariParam% or alamat like %:cariParam% or nohp like %:cariParam% or email like %:cariParam%", nativeQuery = true)
    public List<PemasokModels> getPemasok(@Param("cariParam") String cari);
}
