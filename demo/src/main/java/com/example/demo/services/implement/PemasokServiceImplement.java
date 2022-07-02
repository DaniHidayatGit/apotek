package com.example.demo.services.implement;

import com.example.demo.dto.PemasokDto;
import com.example.demo.dto.SearchDto;
import com.example.demo.models.PemasokModels;
import com.example.demo.models.PemasokModels;
import com.example.demo.repositories.PemasokRepository;
import com.example.demo.services.PemasokService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PemasokServiceImplement implements PemasokService {
    @Autowired
    PemasokRepository pemasokRepository;

    @Override
    public PemasokModels insertPemasok(PemasokDto pemasokDto) {
        PemasokModels models = new PemasokModels();
        PemasokModels result = new PemasokModels();

        try{
            models.setNama(pemasokDto.getNama());
            models.setAlamat(pemasokDto.getAlamat());
            models.setNohp(pemasokDto.getNohp());
            models.setEmail(pemasokDto.getEmail());

            result = pemasokRepository.save(models);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public PemasokDto getPemasokById(int id) {
        PemasokModels models = pemasokRepository.getById(id);
        PemasokDto dto = new PemasokDto();

        dto.setId_peg(models.getId_peg());
        dto.setNama(models.getNama());
        dto.setAlamat(models.getAlamat());
        dto.setNohp(models.getNohp());
        dto.setEmail(models.getEmail());

        return dto;
    }

    @Override
    public PemasokModels updatePemasok(PemasokDto pemasokDto) {
        PemasokModels models = new PemasokModels();
        PemasokModels result = new PemasokModels();

        try{
            models.setId_peg(pemasokDto.getId_peg());
            models.setNama(pemasokDto.getNama());
            models.setAlamat(pemasokDto.getAlamat());
            models.setNohp(pemasokDto.getNohp());
            models.setEmail(pemasokDto.getEmail());

            result = pemasokRepository.save(models);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean deletePemasok(int id) {
        PemasokModels models = pemasokRepository.getById(id);
        pemasokRepository.delete(models);
        return true;
    }

    @Override
    public List<PemasokModels> search(SearchDto searchDto) {
        List<PemasokModels> listData = pemasokRepository.getPemasok(searchDto.getCari());
        return listData;
    }
}
