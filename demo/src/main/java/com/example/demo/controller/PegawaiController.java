package com.example.demo.controller;

import com.example.demo.dto.AdminDto;
import com.example.demo.dto.PegawaiDto;
import com.example.demo.dto.SearchDto;
import com.example.demo.models.AdminModels;
import com.example.demo.models.PegawaiModels;
import com.example.demo.repositories.AdminRepository;
import com.example.demo.repositories.PegawaiRepository;
import com.example.demo.services.PegawaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PegawaiController {
    @Autowired
    private PegawaiRepository pegawaiRepository;

    @Autowired
    private PegawaiService pegawaiService;

    @Autowired
    private AdminRepository adminRepository;

    List<PegawaiModels> pegawaiModels = null;
    PegawaiDto pegawaiDto = new PegawaiDto();
    PegawaiModels result = null;
    SearchDto cari = new SearchDto();

    AdminModels adminModels = new AdminModels();

    @GetMapping("/pegawai")
    public String pegawai(Model model){
        pegawaiModels = pegawaiRepository.getPegawai();
        adminModels = adminRepository.getAdmin();

        // Mengcek apakah yang login itu admin atau bukan
        // Jika admin(owner), maka bisa akses tabel pegawai
        // Jika pegawai(kasir), tidak bisa akses tabel pegawai
        model.addAttribute("isAdmin", adminModels.getEmail());

        model.addAttribute("cari", cari);
        model.addAttribute("Pegawai",pegawaiModels);
        return "pegawai";
    }

    @RequestMapping(value = "/createPegawai", method = RequestMethod.GET)
    public String doCreateData(ModelMap model) throws Exception{
        pegawaiDto = new PegawaiDto();
        adminModels = adminRepository.getAdmin();

        model.addAttribute("isAdmin", adminModels.getEmail());
        model.addAttribute("pegawaiDto", pegawaiDto);
        return "insertpegawai";
    }

    @RequestMapping(value = "/savePegawai", method = RequestMethod.POST)
    public String saveData(PegawaiDto pegawaiDto) throws Exception{
        result = pegawaiService.insertPegawai(pegawaiDto);
        return "redirect:/pegawai";
    }

    @RequestMapping (value = "/updatePegawai", method = RequestMethod.GET)
    public String updatePegawai(ModelMap model, int id) throws Exception{
        pegawaiDto = pegawaiService.getPegawaiById(id);
        adminModels = adminRepository.getAdmin();

        model.addAttribute("isAdmin", adminModels.getEmail());
        model.addAttribute("pegawaiDto", pegawaiDto);
        return "updatepegawai";
    }

    @RequestMapping (value = "/saveUpdatePegawai", method = RequestMethod.POST)
    public String saveUpdatePegawai(PegawaiDto pegawaiDto) throws Exception{
        result = pegawaiService.updatePegawai(pegawaiDto);
        return "redirect:/pegawai";
    }

    @GetMapping (value = "/deletePegawai")
    public String deletePegawai(int id){
        pegawaiService.deletePegawai(id);

        return "redirect:/pegawai";
    }

    @RequestMapping(value = "/searchPegawai", method = RequestMethod.POST)
    public String searchPegawai(SearchDto search, ModelMap model) throws Exception{
        pegawaiModels = pegawaiService.search(search);

        model.addAttribute("Pegawai", pegawaiModels);
        model.addAttribute("cari", cari);

        return "pegawai";
    }
}
