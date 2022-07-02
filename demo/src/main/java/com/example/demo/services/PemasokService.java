package com.example.demo.services;

import com.example.demo.dto.PemasokDto;
import com.example.demo.dto.SearchDto;
import com.example.demo.models.PelangganModels;
import com.example.demo.models.PemasokModels;

import java.util.List;

public interface PemasokService {
    public PemasokModels insertPemasok (PemasokDto pemasokDto);
    public PemasokDto getPemasokById (int id);
    public PemasokModels updatePemasok (PemasokDto pemasokDto);
    public boolean deletePemasok (int id);
    List<PemasokModels> search (SearchDto searchDto);
}
