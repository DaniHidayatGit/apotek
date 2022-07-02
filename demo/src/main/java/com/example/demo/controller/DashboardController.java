package com.example.demo.controller;

import com.example.demo.repositories.DashboardRepository;
import com.example.demo.repositories.ObatRepository;
import com.example.demo.repositories.PelangganRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @Autowired
    private DashboardRepository dashboardRepository;

    @Autowired
    private ObatRepository obatRepository;

    @Autowired
    private PelangganRepository pelangganRepository;

    @GetMapping("/dashboard")
    public String dashboard(ModelMap model){
        model.addAttribute("jumlahPegawai", dashboardRepository.getCountPegawai());
        model.addAttribute("jumlahPelanggan", dashboardRepository.getCountPelanggan());
        model.addAttribute("jumlahPemasok", dashboardRepository.getCountPemasok());
        model.addAttribute("jumlahKategori", dashboardRepository.getCountKategori());
        model.addAttribute("jumlahObat", dashboardRepository.getCountObat());

        model.addAttribute("emptyStock", obatRepository.getEmptyStock());
        model.addAttribute("ayaStock", obatRepository.getAyaStock());
        model.addAttribute("minStock", obatRepository.getMinStock());
        model.addAttribute("sumStock", obatRepository.getSumStock());
        model.addAttribute("countExp", obatRepository.getCountExpObat());
        model.addAttribute("sumExp", obatRepository.getSumExpObat());

        model.addAttribute("classic", pelangganRepository.getClassic());
        model.addAttribute("silver", pelangganRepository.getSilver());
        model.addAttribute("gold", pelangganRepository.getGold());
        return "dashboard";
    }
}
