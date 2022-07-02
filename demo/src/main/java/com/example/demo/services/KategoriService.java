package com.example.demo.services;

import com.example.demo.dto.KategoriDto;
import com.example.demo.dto.SearchDto;
import com.example.demo.models.KategoriModels;
import com.example.demo.models.PelangganModels;

import java.util.List;

public interface KategoriService {
    public KategoriModels insertKategori (KategoriDto KategoriDto);
    public KategoriDto getKategoriById (int id);
    public boolean deleteKategori (int id);
    List<KategoriModels> search (SearchDto searchDto);
}
