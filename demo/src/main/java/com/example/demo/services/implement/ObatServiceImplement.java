package com.example.demo.services.implement;

import com.example.demo.dto.ObatDto;
import com.example.demo.dto.SearchDto;
import com.example.demo.models.ObatModels;
import com.example.demo.models.ObatModels;
import com.example.demo.repositories.ObatRepository;
import com.example.demo.services.ObatService;
import com.example.demo.services.ObatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObatServiceImplement implements ObatService {
    @Autowired
    ObatRepository obatRepository;

    @Override
    public ObatModels insertObat(ObatDto obatDto) {
        ObatModels models = new ObatModels();
        ObatModels result = new ObatModels();

        try{
            models.setNama(obatDto.getNama());
            models.setUnit(obatDto.getUnit());
            models.setStok(obatDto.getStok());
            models.setKategori(obatDto.getKategori());
            models.setHargabeli(obatDto.getHargabeli());
            models.setHargajual(obatDto.getHargajual());
            models.setPemasok(obatDto.getPemasok());
            models.setKedaluwarsa(obatDto.getKedaluwarsa());

            result = obatRepository.save(models);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ObatDto getObatById(int id) {
        ObatModels models = obatRepository.getById(id);
        ObatDto dto = new ObatDto();

        dto.setId_obat(models.getId_obat());
        dto.setNama(models.getNama());
        dto.setStok(models.getStok());
        dto.setKategori(models.getKategori());
        dto.setHargabeli(models.getHargabeli());
        dto.setHargajual(models.getHargajual());
        dto.setPemasok(models.getPemasok());
        dto.setKedaluwarsa(models.getKedaluwarsa());

        return dto;
    }

    @Override
    public ObatModels updateObat(ObatDto obatDto) {
        ObatModels models = new ObatModels();
        ObatModels result = new ObatModels();

        try{
            models.setId_obat(obatDto.getId_obat());
            models.setNama(obatDto.getNama());
            models.setUnit(obatDto.getUnit());
            models.setStok(obatDto.getStok());
            models.setKategori(obatDto.getKategori());
            models.setHargabeli(obatDto.getHargabeli());
            models.setHargajual(obatDto.getHargajual());
            models.setPemasok(obatDto.getPemasok());
            models.setKedaluwarsa(obatDto.getKedaluwarsa());

            result = obatRepository.save(models);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean deleteObat(int id) {
        ObatModels models = obatRepository.getById(id);
        obatRepository.delete(models);
        return true;
    }

    @Override
    public List<ObatModels> search(SearchDto searchDto) {
        List<ObatModels> listData = obatRepository.getObat(searchDto.getCari());
        return listData;
    }
}
