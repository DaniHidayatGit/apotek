package com.example.demo.services;

import com.example.demo.dto.PelangganDto;
import com.example.demo.dto.SearchDto;
import com.example.demo.models.PegawaiModels;
import com.example.demo.models.PelangganModels;

import java.util.List;

public interface PelangganService {
    public PelangganModels insertPelanggan (PelangganDto pelangganDto);
    public PelangganDto getPelangganById (int id);
    public PelangganModels updatePelanggan (PelangganDto pelangganDto);
    public boolean deletePelanggan (int id);
    List<PelangganModels> search (SearchDto searchDto);
}
