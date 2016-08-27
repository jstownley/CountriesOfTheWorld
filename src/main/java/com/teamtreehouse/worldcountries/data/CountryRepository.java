package com.teamtreehouse.worldcountries.data;

import com.teamtreehouse.worldcountries.controller.NotFoundException;
import com.teamtreehouse.worldcountries.model.Country;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

@Component
public class CountryRepository {

    private static final List<Country> ALL_COUNTRIES = Arrays.asList(
        new Country("Brazil", "Brasilia", 190000000, new String[]{"Portuguese"}),
        new Country("Hungary", "Budapest", 9855571, new String[]{"Hungarian"}),
        new Country("New Zealand", "Wellington", 4709310, new String[]{"English", "Maori", "NZ Sign Language"}),
        new Country("Canada", "Ottawa", 36155487, new String[]{"English", "French"}),
        new Country("South Korea", "Seoul", 50801405, new String[]{"Korean"})
    );

    public List<Country> getAllCountries() {
        return ALL_COUNTRIES;
    }

    public Country findBySlug(String slug) {
        return ALL_COUNTRIES.stream()
                            .filter(c ->c.getSlug().compareTo(slug)==0)
            .findFirst()
            .orElseThrow(NotFoundException::new);
    }

    public List<Country> sortByCountryName(String order) {
        if (0 == order.compareTo("descending")) {
            return ALL_COUNTRIES.stream()
                .sorted(comparing(Country::getName).reversed())
                .collect(Collectors.toList());
        }
        return ALL_COUNTRIES.stream()
            .sorted(comparing(Country::getName))
            .collect(Collectors.toList());
    }

    public List<Country> sortByCapitalName(String order) {
        if (0 == order.compareTo("descending")) {
            return ALL_COUNTRIES.stream()
                .sorted(comparing(Country::getCapital).reversed())
                .collect(Collectors.toList());
        }
        return ALL_COUNTRIES.stream()
            .sorted(comparing(Country::getCapital))
            .collect(Collectors.toList());
    }

    public List<Country> sortByNumberOfLanguages(String order) {
        if (0 == order.compareTo("descending")) {
            return ALL_COUNTRIES.stream()
                .sorted(comparing(Country::getNumberOfLanguages).reversed())
                .collect(Collectors.toList());
        }
        return ALL_COUNTRIES.stream()
            .sorted(comparing(Country::getNumberOfLanguages))
            .collect(Collectors.toList());
    }

    public List<Country> sortByPopulation(String order) {
        if (0 == order.compareTo("descending")) {
            return ALL_COUNTRIES.stream()
                .sorted(comparing(Country::getPopulation).reversed())
                .collect(Collectors.toList());
        }
        return ALL_COUNTRIES.stream()
            .sorted(comparing(Country::getPopulation))
            .collect(Collectors.toList());
    }
}
