package com.example.demo.services;

import com.example.demo.dto.ObatDto;
import com.example.demo.dto.SearchDto;
import com.example.demo.models.ObatModels;
import com.example.demo.models.PelangganModels;

import java.util.List;

public interface ObatService {
    public ObatModels insertObat (ObatDto obatDto);
    public ObatDto getObatById (int id);
    public ObatModels updateObat (ObatDto obatDto);
    public boolean deleteObat (int id);
    List<ObatModels> search (SearchDto searchDto);
}
