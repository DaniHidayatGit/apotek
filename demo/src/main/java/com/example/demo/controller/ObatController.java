package com.example.demo.controller;

import com.example.demo.dto.KategoriDto;
import com.example.demo.dto.ObatDto;
import com.example.demo.dto.SearchDto;
import com.example.demo.models.KategoriModels;
import com.example.demo.models.ObatModels;
import com.example.demo.models.PemasokModels;
import com.example.demo.repositories.KategoriRepository;
import com.example.demo.repositories.ObatRepository;
import com.example.demo.repositories.PemasokRepository;
import com.example.demo.services.ObatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ObatController {
    @Autowired
    private ObatRepository obatRepository;

    @Autowired
    private ObatService obatService;

    @Autowired
    private KategoriRepository kategoriRepository;

    @Autowired
    private PemasokRepository pemasokRepository;

    List<ObatModels> obatModels = null;
    ObatDto obatDto = new ObatDto();
    ObatModels result = null;
    SearchDto cari = new SearchDto();

    @GetMapping("/obat")
    public String obat(Model model){
        obatModels = obatRepository.getObat();

        model.addAttribute("Obat", obatModels);
        model.addAttribute("cari", cari);
        return "obat";
    }

    @RequestMapping(value = "/createObat", method = RequestMethod.GET)
    public String doCreateData(ModelMap model) throws Exception{
        obatDto = new ObatDto();

        List<String> namaKategori = obatRepository.getNamaKategori();
        List<String> namaPemasok = obatRepository.getNamaPemasok();

        model.addAttribute("Kategori", namaKategori);
        model.addAttribute("Pemasok", namaPemasok);

        model.addAttribute("obatDto", obatDto);
        return "insertobat";
    }

    @RequestMapping(value = "/saveObat", method = RequestMethod.POST)
    public String saveData(ObatDto obatDto) throws Exception{

        result = obatService.insertObat(obatDto);
        return "redirect:/obat";
    }

    @RequestMapping (value = "/updateObat", method = RequestMethod.GET)
    public String updateObat(ModelMap model, int id) throws Exception{
        List<String> namaKategori = obatRepository.getNamaKategori();
        List<String> namaPemasok = obatRepository.getNamaPemasok();

        obatDto = obatService.getObatById(id);

        model.addAttribute("obatDto", obatDto);
        model.addAttribute("Kategori", namaKategori);
        model.addAttribute("Pemasok", namaPemasok);
        return "updateobat";
    }

    @RequestMapping (value = "/saveUpdateObat", method = RequestMethod.POST)
    public String saveUpdateMahasiswa(ObatDto obatDto) throws Exception{
        result = obatService.updateObat(obatDto);
        return "redirect:/obat";
    }

    @GetMapping (value = "/deleteObat")
    public String deleteObat(int id){
        obatService.deleteObat(id);

        return "redirect:/obat";
    }

    @RequestMapping(value = "/searchObat", method = RequestMethod.POST)
    public String searchObat(SearchDto search, ModelMap model) throws Exception{
        obatModels = obatService.search(search);

        model.addAttribute("Obat", obatModels);
        model.addAttribute("cari", cari);

        return "obat";
    }
}
