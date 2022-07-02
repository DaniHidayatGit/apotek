package com.example.demo.services.implement;

import com.example.demo.dto.KategoriDto;
import com.example.demo.dto.SearchDto;
import com.example.demo.models.KategoriModels;
import com.example.demo.models.KategoriModels;
import com.example.demo.repositories.KategoriRepository;
import com.example.demo.services.KategoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KategoriServiceImplement implements KategoriService {
    @Autowired
    KategoriRepository kategoriRepository;

    @Override
    public KategoriModels insertKategori(KategoriDto kategoriDto) {
        KategoriModels models = new KategoriModels();
        KategoriModels result = new KategoriModels();

        try{
            models.setNama(kategoriDto.getNama());
            models.setKeterangan(kategoriDto.getKeterangan());

            result = kategoriRepository.save(models);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public KategoriDto getKategoriById(int id) {
        KategoriModels models = kategoriRepository.getById(id);
        KategoriDto dto = new KategoriDto();

        dto.setId_kat(models.getId_kat());
        dto.setNama(models.getNama());
        dto.setKeterangan(models.getKeterangan());

        return dto;
    }

    @Override
    public boolean deleteKategori(int id) {
        KategoriModels models = kategoriRepository.getById(id);
        kategoriRepository.delete(models);
        return true;
    }

    @Override
    public List<KategoriModels> search(SearchDto searchDto) {
        List<KategoriModels> listData = kategoriRepository.getKategori(searchDto.getCari());
        return listData;
    }
}
