package com.example.demo.controller;

import com.example.demo.dto.MallService;
import com.example.demo.dto.PelangganDto;
import com.example.demo.dto.SearchDto;
import com.example.demo.models.PelangganModels;
import com.example.demo.repositories.PelangganRepository;
import com.example.demo.services.EmailService;
import com.example.demo.services.PelangganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PelangganController {
    @Autowired
    private PelangganRepository pelangganRepository;

    @Autowired
    private PelangganService pelangganService;

    List<PelangganModels> pelangganModels = null;
    PelangganDto pelangganDto = new PelangganDto();
    PelangganModels result = null;
    SearchDto cari = new SearchDto();

    @GetMapping("/pelanggan")
    public String pelanggan(Model model){
        pelangganModels = pelangganRepository.getPelanggan();

        model.addAttribute("Pelanggan",pelangganModels);
        model.addAttribute("cari", cari);
        return "pelanggan";
    }

    @RequestMapping(value = "/createPelanggan", method = RequestMethod.GET)
    public String doCreateData(ModelMap model) throws Exception{
        pelangganDto = new PelangganDto();
        model.addAttribute("pelangganDto", pelangganDto);
        return "insertpelanggan";
    }

    @RequestMapping(value = "/savePelanggan", method = RequestMethod.POST)
    public String saveData(PelangganDto pelangganDto) throws Exception{
        result = pelangganService.insertPelanggan(pelangganDto);
        return "redirect:/pelanggan";
    }

    @RequestMapping (value = "/updatePelanggan", method = RequestMethod.GET)
    public String updatePelanggan(ModelMap model, int id) throws Exception{
        pelangganDto = pelangganService.getPelangganById(id);
        model.addAttribute("pelangganDto", pelangganDto);
        return "updatepelanggan";
    }

    @RequestMapping (value = "/saveUpdatePelanggan", method = RequestMethod.POST)
    public String saveUpdateMahasiswa(PelangganDto pelangganDto) throws Exception{
        result = pelangganService.updatePelanggan(pelangganDto);
        return "redirect:/pelanggan";
    }

    @GetMapping (value = "/deletePelanggan")
    public String deletePelanggan(int id){
        pelangganService.deletePelanggan(id);

        return "redirect:/pelanggan";
    }

    @RequestMapping(value = "/searchPelanggan", method = RequestMethod.POST)
    public String searchPelanggan(SearchDto search, ModelMap model) throws Exception{
        pelangganModels = pelangganService.search(search);

        model.addAttribute("Pelanggan", pelangganModels);
        model.addAttribute("cari", cari);

        return "pelanggan";
    }
}
