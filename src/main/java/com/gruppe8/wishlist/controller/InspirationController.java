package com.gruppe8.wishlist.controller;

import com.gruppe8.wishlist.service.InspirationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class InspirationController {

    private final InspirationService inspirationService;

    public InspirationController(InspirationService inspirationService) {
        this.inspirationService = inspirationService;

    }

    @GetMapping("/inspiration")
    public String showInspiration(
            @RequestParam(required = false) String tag,
            @RequestParam(required = false) String sort,
            Model model) {

        var inspirations = inspirationService.getAllInspirations();

        if (tag != null && !tag.isEmpty()) {
            inspirations = inspirations.stream().filter(i -> i.getTag().equalsIgnoreCase(tag))
                    .toList();
        }

        if ("priceAsc".equals(sort)) {
            inspirations = inspirations.stream().sorted((a, b) -> Double.compare(a.getPrice(), b.getPrice())).toList();
        } else if ("priceDesc".equals(sort)) {
            inspirations = inspirations.stream().sorted((a, b) -> Double.compare(b.getPrice(), a.getPrice())).toList();
        }

        model.addAttribute("inspirations", inspirations);
        model.addAttribute("selectedTag", tag);
        model.addAttribute("selectedSort", sort);

        return "inspiration";
    }
}
