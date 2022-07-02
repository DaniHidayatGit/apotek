package com.example.demo.controller;

import com.example.demo.dto.KategoriDto;
import com.example.demo.dto.SearchDto;
import com.example.demo.models.KategoriModels;
import com.example.demo.repositories.KategoriRepository;
import com.example.demo.services.KategoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class KategoriController {
    @Autowired
    private KategoriRepository kategoriRepository;

    @Autowired
    private KategoriService kategoriService;

    List<KategoriModels> kategoriModels = null;
    KategoriDto kategoriDto = new KategoriDto();
    KategoriModels result = null;
    SearchDto cari = new SearchDto();

    @GetMapping("/kategori")
    public String kategori(Model model){
        kategoriModels = kategoriRepository.getKategori();

        model.addAttribute("Kategori",kategoriModels);
        model.addAttribute("cari", cari);
        return "kategori";
    }

    @RequestMapping(value = "/createKategori", method = RequestMethod.GET)
    public String doCreateData(ModelMap model) throws Exception{
        kategoriDto = new KategoriDto();
        model.addAttribute("kategoriDto", kategoriDto);
        return "insertkategori";
    }

    @RequestMapping(value = "/saveKategori", method = RequestMethod.POST)
    public String saveData(KategoriDto kategoriDto) throws Exception{
        result = kategoriService.insertKategori(kategoriDto);
        return "redirect:/kategori";
    }

    @GetMapping (value = "/deleteKategori")
    public String deleteKategori(int id){
        kategoriService.deleteKategori(id);

        return "redirect:/kategori";
    }

    @RequestMapping(value = "/searchKategori", method = RequestMethod.POST)
    public String searchKategori(SearchDto search, ModelMap model) throws Exception{
        kategoriModels = kategoriService.search(search);

        model.addAttribute("Kategori", kategoriModels);
        model.addAttribute("cari", cari);

        return "kategori";
    }
}
