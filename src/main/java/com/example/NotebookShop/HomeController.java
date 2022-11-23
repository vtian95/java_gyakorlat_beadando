package com.example.NotebookShop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;
import javax.validation.Validation;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {

        return "index";
    }

    @GetMapping("/hiba")
    public String hiba() {

        return "hiba";
    }

    @GetMapping("/home")
    public String user(Model model) {

        return "user";
    }

    @GetMapping("/admin/home")
    public String admin() {

        return "admin";
    }

    @GetMapping("/regisztral")
    public String greetingForm(Model model) {
        model.addAttribute("reg", new User());
        return "regisztral";
    }

    @GetMapping("/contact")
    public String Contact(Model model) {
        model.addAttribute("uzenetek", new Uzenetek());
        return "contact";
    }

    @GetMapping("/gepek")
    public String gepek(Model model) {

        String gyarto = gyart();
        model.addAttribute("gyarto", gyarto);

        String memoria = memoriameret();
        model.addAttribute("memoria", memoria);

        String hdd = hddmeret();
        model.addAttribute("hdd", hdd);

        String vga = videokartyak();
        model.addAttribute("vga", vga);

        String ara = price();
        model.addAttribute("ara", ara);

        return "gepek";
    }

    @GetMapping("/admin/messages")
    public String uzik(Model model) {
        String targy = targyolvas();
        model.addAttribute("targy",targy);

        String uzenet = uzenetolvas();
        model.addAttribute("uzenet", uzenet);

        return "messages";
    }

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private GepRepo gepRepo;

    @Autowired
    private ProcesszorRepo processzorRepo;

    @Autowired
    private UzenetRepository uzenetRepo;


    @PostMapping("/beregisztral")
    public String Regisztráció(@ModelAttribute User user, Model model) {
        for(User felhasznalo2: userRepo.findAll())
            if(felhasznalo2.getEmail().equals(user.getEmail())){
                model.addAttribute("uzenet", "Ez az email cím vagy felhasználó név már foglalt! Válassz másikat!");
                return "hibasreg";
            }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role role = new Role();

        role.setId(3); role.setName("ROLE_USER");
        List<Role> rolelist = new ArrayList<Role>();
        rolelist.add(role);
        user.setRoles(rolelist);
        userRepo.save(user);
        model.addAttribute("id", user.getId());
        return "sikeresreg";
    }



    @PostMapping(value = "/uzenetkuld")
    public String Üzenetküldés(@Valid @ModelAttribute Validation validation, Uzenetek uzenet , Uzenetek targy) {
        if (uzenet.getUzenet().length() < 10 || uzenet.getTargy().length() < 5){
            return "hiba";
        }
        uzenetRepo.save(targy);
        uzenetRepo.save(uzenet);
        return "contactjo";
    }



    String gyart(){
        String gyarto="";
        for(Gep gepek: gepRepo.findAll()){
            gyarto+=gepek.getGyarto() +" "+gepek.getTipus();
            gyarto+="<br>";
        }
        return gyarto;
    }
    String memoriameret(){
        String memoria="";
        for(Gep gepek: gepRepo.findAll()){
            memoria+=gepek.getMemoria()+" MB";
            memoria+="<br>";
        }
        return memoria;
    }
    String hddmeret(){
        String hdd ="";
        for(Gep gepek: gepRepo.findAll()){
            hdd+=gepek.getMerevlemez()+" GB";
            hdd+="<br>";
        }
        return hdd;
    }

    String videokartyak(){
        String vga="";
        for(Gep gepek: gepRepo.findAll()){
            vga+=gepek.getVideovezerlo();
            vga+="<br>";
        }
        return vga;
    }
    String price(){
        String ara="";
        for(Gep gepek: gepRepo.findAll()){
            ara+=gepek.getAr()+" Ft";
            ara+="<br>";
        }
        return ara;
    }

    String cpuk(){
        String procik="";
        String az ="";
        for(Gep gepek: gepRepo.findAll()){
            procik+=gepek.getGyarto()+" "+gepek.getTipus()+gepek.getId();
            az+= gepek.getId();
            for(Processzor processzorok: processzorRepo.findAll()){
                if(procik.contains("az"))
                {

                }
            }

        }

        return procik;
    }

    String targyolvas(){
        String targy="";
        for(Uzenetek uzenetek: uzenetRepo.findAll()){
            targy+= uzenetek.getTargy();
            targy+="<br>";
        }
        return targy;

    }

    String uzenetolvas(){
        String targy="";
        for(Uzenetek uzenetek: uzenetRepo.findAll()){
            targy+= uzenetek.getUzenet();
            targy+="<br>";
        }
        return targy;

    }



}
