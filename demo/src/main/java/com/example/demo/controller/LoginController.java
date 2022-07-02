package com.example.demo.controller;

import com.example.demo.dto.AdminDto;
import com.example.demo.dto.MallResponse;
import com.example.demo.dto.MallService;
import com.example.demo.models.AdminModels;
import com.example.demo.models.PegawaiModels;
import com.example.demo.repositories.AdminRepository;
import com.example.demo.repositories.PegawaiRepository;
import com.example.demo.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

@Controller
public class LoginController {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PegawaiRepository pegawaiRepository;

    @Autowired
    private EmailService emailService;

    AdminDto adminDto = new AdminDto();
    MallService sendEmail = new MallService();
    MallService getSendEmail = null;

    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("adminDto", adminDto);
        return "login";
    }

    @RequestMapping(value = "/cekLogin", method = RequestMethod.POST)
    public String cekLogin(AdminDto adminDto, HttpSession session) {

        AdminModels admin = adminRepository.getAdmin();
        List<PegawaiModels> pegawai = pegawaiRepository.getPegawai();

        LocalDateTime now = LocalDateTime.now();
        String sekarang = now.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(new Locale("ID")));

        // Cek admin(owner) login
        if(adminDto.getEmail().equalsIgnoreCase(admin.getEmail()) && adminDto.getPassword().equalsIgnoreCase(admin.getPassword())) {
            session.setAttribute("email", adminDto.getEmail());

            sendEmail.setTo(admin.getEmail());
            sendEmail.setSubject("Login Admin");
            sendEmail.setText("Anda telah melakukan login pada " + sekarang);
            getSendEmail = sendEmail;
            kirimEmail(getSendEmail);

            return "redirect:/dashboard";
        }else {
            // Cek Pegawai Login
            for(PegawaiModels x : pegawai){
                if(Objects.equals(x.getEmail(), adminDto.getEmail()) && Objects.equals(x.getPassword(), adminDto.getPassword())){
                    session.setAttribute("email", adminDto.getEmail());

                    sendEmail.setTo(admin.getEmail());
                    sendEmail.setSubject("Login Pegawai");
                    sendEmail.setText( "Pegawai anda " + x.getNama() + " telah melakukan login pada " + sekarang);
                    getSendEmail = sendEmail;
                    kirimEmail(getSendEmail);

                    return "redirect:/dashboard";
                }
            }
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession httpSession){
        httpSession.removeAttribute("email");
        return "redirect:/login";
    }

    @PostMapping("/kirimEmail")
    public MallResponse kirimEmail(MallService request){
        return emailService.sendEmail(request);
    }
}
