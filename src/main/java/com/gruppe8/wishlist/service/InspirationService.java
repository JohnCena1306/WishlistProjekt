package com.gruppe8.wishlist.service;

import com.gruppe8.wishlist.model.Inspiration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InspirationService {

    public List<Inspiration> getAllInspirations() {
        return List.of(
                new Inspiration("Rolex", "Daytona", "Eksklusivt luksusur kendt for sit ikoniske design", 185000, "/images/Rolex.jpg", "Luxury"),
                new Inspiration("Patek Philippe", "Nautilus", "Et af verdens mest eftertragtede luksusure", 350000, "/images/patek.jpg", "Luxury"),
                new Inspiration("Louis Vuitton", "Capucines Bag", "High-end designer taske i premium kvalitet", 42000, "/images/capcines.jpg", "Fashion"),
                new Inspiration("Hermès", "Birkin Bag", "Verdens mest eksklusive taske med ekstrem efterspørgsel", 120000, "/images/birkinbag.jpg", "Fashion"),
                new Inspiration("Tesla", "Model 3", "Elektrisk bil med høj performance og moderne teknologi", 350000, "/images/tesla.jpg", "Tech"),
                new Inspiration("Bang & Olufsen", "Beolab 28", "High-end højtalersystem i luksusklassen", 110000, "/images/BangandOlufsen.jpg", "Tech"),
                new Inspiration("Canon", "EOS R5 Kit", "Professionelt kamera til foto og video i topklasse", 45000, "/images/canon.jpg", "Tech"),
                new Inspiration("DJI", "Inspire 3 Drone", "Professionel drone til filmproduktion", 120000, "/images/DJI.jpg", "Tech"),
                new Inspiration("Technogym", "Personal Line Home Gym", "Eksklusivt fitnessudstyr til hjemmet", 90000, "/images/gym.jpg", "Lifestyle"),
                new Inspiration("Vitra", "Eames Lounge Chair", "Ikonisk designerstol i luksussegmentet", 55000, "/images/vitra.jpg", "Lifestyle"),
                new Inspiration("Omega", "Speedmaster Moonwatch", "Klassisk luksusur med rumhistorie", 65000, "/images/omega.jpg", "Luxury"),
                new Inspiration("Cartier", "Love Bracelet", "Eksklusivt smykke i 18k guld", 75000, "/images/Cartier.jpg", "Luxury"),
                new Inspiration("Rimowa", "Trunk Plus", "Premium luksus kuffert i aluminium", 15000, "/images/Rimowa.jpg", "Travel"),
                new Inspiration("Apple", "Mac Pro", "Ekstrem high-end workstation til professionelle", 80000, "/images/macpro.jpg", "Tech")
        );
    }
}