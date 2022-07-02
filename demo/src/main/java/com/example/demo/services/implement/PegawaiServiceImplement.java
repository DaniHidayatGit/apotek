package com.example.demo.services.implement;

import com.example.demo.dto.PegawaiDto;
import com.example.demo.dto.SearchDto;
import com.example.demo.models.PegawaiModels;
import com.example.demo.repositories.PegawaiRepository;
import com.example.demo.services.PegawaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PegawaiServiceImplement implements PegawaiService {
    @Autowired
    PegawaiRepository pegawaiRepository;

    @Override
    public PegawaiModels insertPegawai(PegawaiDto pegawaiDto) {
        PegawaiModels models = new PegawaiModels();
        PegawaiModels result = new PegawaiModels();

        try{
            models.setNama(pegawaiDto.getNama());
            models.setJk(pegawaiDto.getJk());
            models.setAlamat(pegawaiDto.getAlamat());
            models.setNohp(pegawaiDto.getNohp());
            models.setEmail(pegawaiDto.getEmail());
            models.setPassword(pegawaiDto.getPassword());
            models.setStatus("Pegawai");

            result = pegawaiRepository.save(models);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public PegawaiDto getPegawaiById(int id) {
        PegawaiModels models = pegawaiRepository.getById(id);
        PegawaiDto dto = new PegawaiDto();

        dto.setId_peg(models.getId_peg());
        dto.setNama(models.getNama());
        dto.setJk(models.getJk());
        dto.setAlamat(models.getAlamat());
        dto.setNohp(models.getNohp());
        dto.setEmail(models.getEmail());
        dto.setStatus(models.getStatus());
        dto.setPassword(models.getPassword());

        return dto;
    }

    @Override
    public PegawaiModels updatePegawai(PegawaiDto pegawaiDto) {
        PegawaiModels models = new PegawaiModels();
        PegawaiModels result = new PegawaiModels();

        try{
            models.setId_peg(pegawaiDto.getId_peg());
            models.setNama(pegawaiDto.getNama());
            models.setJk(pegawaiDto.getJk());
            models.setAlamat(pegawaiDto.getAlamat());
            models.setNohp(pegawaiDto.getNohp());
            models.setEmail(pegawaiDto.getEmail());
            models.setPassword(pegawaiDto.getPassword());
            models.setStatus("Pegawai");

            result = pegawaiRepository.save(models);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean deletePegawai(int id) {
        PegawaiModels models = pegawaiRepository.getById(id);
        pegawaiRepository.delete(models);
        return true;
    }

    @Override
    public List<PegawaiModels> search(SearchDto searchDto) {
        List<PegawaiModels> listData = pegawaiRepository.getPegawai(searchDto.getCari());
        return listData;
    }
}
