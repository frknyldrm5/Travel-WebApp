package be.thomasmore.travelwebapp.controllers;


import be.thomasmore.travelwebapp.model.Client;
import be.thomasmore.travelwebapp.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Optional;
import java.util.Random;

@Controller
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/greetingclient")
    public String greetingNewClient(Model model){
        Optional<Client> optionalClient = clientRepository.findById(1);
        if (optionalClient.isPresent()){
            Client c = optionalClient.get();
            LocalDateTime now = LocalDateTime.now();
            String groet = "";
            if (now.getHour()<12){
                groet += "Goedemoregen";
            }else if(now.getHour()>16){
                groet += "Goedeavond";
            }else{
                groet += "Goedemiddag";
            }
            if (c.getGender().equals("F")){
                groet += "mevrouw";
            }
            if (c.getGender().equals("M")){
                groet += "meneer";
            }
            groet += c.getName();
            model.addAttribute("groet",groet);

        }
        return "newclient";

    }



    @GetMapping("/showcode")
    public String showSecretCode(Model model) {
        Optional<Client> optionalClient = clientRepository.findById(1);
        String show = "";
        if (optionalClient.isPresent()) {
            Client c = optionalClient.get();
            String code = getClientCode(c);
            if (c.getGender().equals("F")) show += "Mevrouw ";
            if (c.getGender().equals("M")) show += "Meneer ";
            show += c.getName();
            show += ", uw secret code is " + code;

        } else {
            show = "deze klant kan niet gevonden worden";
        }
        model.addAttribute("showcode", show);
        return "showsecretcode";
    }

    private String getClientCode(Client client) {
        String code = client.getName().substring(0,2).toLowerCase();
        code += client.getName().substring(client.getName().length() - 1).toLowerCase();
        Calendar calendar = Calendar.getInstance();
        code += calendar.get(Calendar.DAY_OF_MONTH);
        Random r = new Random();
        code += r.nextInt(calendar.get(Calendar.YEAR)) + 1;
        return code;
    }


}
