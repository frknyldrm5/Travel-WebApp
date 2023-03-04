package be.thomasmore.travelwebapp.controllers;

import be.thomasmore.travelwebapp.model.Venue;
import be.thomasmore.travelwebapp.repositories.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class VenueController {
    @Autowired
    private VenueRepository venueRepository;

    @GetMapping("/venuedetails")
    public String venueDetails(Model model){
//        Venue venue=new Venue("Roma","https://shoppenin.mechelen.be/blog-boejskammeree");
//        model.addAttribute("venue",venue);
//        venue.setCapacity(2000);
//        venue.setCity("Antwerpen");
//        venue.setIndoor(true);
//        venue.setFoodProvided(false);
//        venue.setFreeParkingAvailable(true);
//        venue.setDistanceFromPublicTransportInKm(2.4);

        Optional<Venue> optionalVenue=venueRepository.findById(1);
        if (optionalVenue.isPresent()){
            model.addAttribute("venue",optionalVenue.get());
        }

        return "venuedetails";
    }
}
