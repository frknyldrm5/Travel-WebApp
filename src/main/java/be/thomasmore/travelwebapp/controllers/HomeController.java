package be.thomasmore.travelwebapp.controllers;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class HomeController {
    @GetMapping({"/","/home"})
    public String home(Model model) {
        int value = 23+ 29;
        model.addAttribute("value",value);
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model){
        String myName ="Furkan";
        String myAddress = "Smedenstraat 32";
        String myCity = "Antwerp";
        model.addAttribute("myName",myName);
        model.addAttribute("myAddress",myAddress);
        model.addAttribute("myCity",myCity);
        return "about";
    }

    @GetMapping("/pay")
    public String pay(Model model){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatDateTime = now.format(format);

        LocalDateTime after = now.plusDays(30);
        String formatDateTimeAfter=after.format(format);

        model.addAttribute("formatDateTime",formatDateTime);
        model.addAttribute("formatDateTimeAfter",formatDateTimeAfter);

        return "pay";

    }

}

