package com.example.demo.controller;

import com.example.demo.dto.PemasokDto;
import com.example.demo.dto.SearchDto;
import com.example.demo.models.PemasokModels;
import com.example.demo.repositories.PemasokRepository;
import com.example.demo.services.PemasokService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PemasokController {
    @Autowired
    private PemasokRepository pemasokRepository;

    @Autowired
    private PemasokService pemasokService;

    List<PemasokModels> pemasokModels = null;
    PemasokDto pemasokDto = new PemasokDto();
    PemasokModels result = null;
    SearchDto cari = new SearchDto();

    @GetMapping("/pemasok")
    public String pemasok(Model model){
        pemasokModels = pemasokRepository.getPemasok();

        model.addAttribute("Pemasok",pemasokModels);
        model.addAttribute("cari", cari);
        return "pemasok";
    }

    @RequestMapping(value = "/createPemasok", method = RequestMethod.GET)
    public String doCreateData(ModelMap model) throws Exception{
        pemasokDto = new PemasokDto();
        model.addAttribute("pemasokDto", pemasokDto);
        return "insertpemasok";
    }

    @RequestMapping(value = "/savePemasok", method = RequestMethod.POST)
    public String saveData(PemasokDto pemasokDto) throws Exception{
        result = pemasokService.insertPemasok(pemasokDto);
        return "redirect:/pemasok";
    }

    @RequestMapping (value = "/updatePemasok", method = RequestMethod.GET)
    public String updatePemasok(ModelMap model, int id) throws Exception{
        pemasokDto = pemasokService.getPemasokById(id);
        model.addAttribute("pemasokDto", pemasokDto);
        return "updatepemasok";
    }

    @RequestMapping (value = "/saveUpdatePemasok", method = RequestMethod.POST)
    public String saveUpdateMahasiswa(PemasokDto pemasokDto) throws Exception{
        result = pemasokService.updatePemasok(pemasokDto);
        return "redirect:/pemasok";
    }

    @GetMapping (value = "/deletePemasok")
    public String deletePemasok(int id){
        pemasokService.deletePemasok(id);

        return "redirect:/pemasok";
    }

    @RequestMapping(value = "/searchPemasok", method = RequestMethod.POST)
    public String searchPemasok(SearchDto search, ModelMap model) throws Exception{
        pemasokModels = pemasokService.search(search);

        model.addAttribute("Pemasok", pemasokModels);
        model.addAttribute("cari", cari);

        return "pemasok";
    }
}
