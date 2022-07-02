package com.example.demo.services.implement;

import com.example.demo.dto.PelangganDto;
import com.example.demo.dto.SearchDto;
import com.example.demo.models.PegawaiModels;
import com.example.demo.models.PelangganModels;
import com.example.demo.repositories.PelangganRepository;
import com.example.demo.services.PelangganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PelangganServiceImplement implements PelangganService {
    @Autowired
    PelangganRepository pelangganRepository;

    @Override
    public PelangganModels insertPelanggan(PelangganDto pelangganDto) {
        PelangganModels models = new PelangganModels();
        PelangganModels result = new PelangganModels();

        try{
            models.setNama(pelangganDto.getNama());
            models.setJk(pelangganDto.getJk());
            models.setAlamat(pelangganDto.getAlamat());
            models.setNohp(pelangganDto.getNohp());
            models.setEmail(pelangganDto.getEmail());
            models.setLevel("Classic");
            models.setRiwayat(0);

            result = pelangganRepository.save(models);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public PelangganDto getPelangganById(int id) {
        PelangganModels models = pelangganRepository.getById(id);
        PelangganDto dto = new PelangganDto();

        dto.setId_peg(models.getId_peg());
        dto.setNama(models.getNama());
        dto.setJk(models.getJk());
        dto.setAlamat(models.getAlamat());
        dto.setNohp(models.getNohp());
        dto.setEmail(models.getEmail());
        dto.setLevel(models.getLevel());
        dto.setRiwayat(models.getRiwayat());

        return dto;
    }

    @Override
    public PelangganModels updatePelanggan(PelangganDto pelangganDto) {
        PelangganModels models = new PelangganModels();
        PelangganModels result = new PelangganModels();

        try{
            models.setId_peg(pelangganDto.getId_peg());
            models.setNama(pelangganDto.getNama());
            models.setJk(pelangganDto.getJk());
            models.setAlamat(pelangganDto.getAlamat());
            models.setNohp(pelangganDto.getNohp());
            models.setEmail(pelangganDto.getEmail());

            result = pelangganRepository.save(models);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean deletePelanggan(int id) {
        PelangganModels models = pelangganRepository.getById(id);
        pelangganRepository.delete(models);
        return true;
    }

    @Override
    public List<PelangganModels> search(SearchDto searchDto) {
        List<PelangganModels> listData = pelangganRepository.getPelanggan(searchDto.getCari());
        return listData;
    }
}
