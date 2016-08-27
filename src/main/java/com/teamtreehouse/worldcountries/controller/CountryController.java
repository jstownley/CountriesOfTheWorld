package com.teamtreehouse.worldcountries.controller;

import com.teamtreehouse.worldcountries.data.CountryRepository;
import com.teamtreehouse.worldcountries.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @RequestMapping("/")
    public String listCountries(ModelMap modelMap) {
        List<Country> allCountries = countryRepository.sortByCountryName("ascending");
        modelMap.put("countries", allCountries);
        return "index";
    }

    @RequestMapping("/{slug}")
    public String getCountryDetail(@PathVariable String slug, ModelMap modelMap) {
        Country country = countryRepository.findBySlug(slug);
        modelMap.put("country", country);
        return "country-details";
    }

    @RequestMapping("/sort={sortBy}")
    public String getSortedCountries(@PathVariable String sortBy, ModelMap modelMap) {
        List<Country> allCountries = countryRepository.sortByCountryName("ascending");
        if (0 == sortBy.compareTo("capital")) {
            allCountries = countryRepository.sortByCapitalName("ascending");
        } else if (0 == sortBy.compareTo("population")) {
            allCountries = countryRepository.sortByPopulation("descending");
        } else if (0 == sortBy.compareTo("languages")) {
            allCountries = countryRepository.sortByNumberOfLanguages("descending");
        }
        modelMap.put("countries", allCountries);
        return "index";
    }
}
