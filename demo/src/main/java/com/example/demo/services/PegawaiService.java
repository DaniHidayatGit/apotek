package com.example.demo.services;

import com.example.demo.dto.PegawaiDto;
import com.example.demo.dto.SearchDto;
import com.example.demo.models.PegawaiModels;

import java.util.List;


public interface PegawaiService {
    public PegawaiModels insertPegawai (PegawaiDto pegawaiDto);
    public PegawaiDto getPegawaiById (int id);
    public PegawaiModels updatePegawai (PegawaiDto pegawaiDto);
    public boolean deletePegawai (int id);
    List<PegawaiModels> search (SearchDto searchDto);

}
