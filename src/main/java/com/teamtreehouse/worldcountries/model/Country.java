package com.teamtreehouse.worldcountries.model;

import com.github.slugify.Slugify;

public class Country {
    private String name;
    private String capital;
    private int population;
    private String populationString;
    private String[] officialLanguages;
    private String slug;

    public Country(String name, String capital, int population, String[] officialLanguages) {
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.officialLanguages = officialLanguages;

        Slugify slugify = new Slugify();
        this.slug = slugify.slugify(name);

        this.populationString = ConvertToString(population);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String[] getOfficialLanguages() {
        return officialLanguages;
    }

    public void setOfficialLanguages(String[] officialLanguages) {
        this.officialLanguages = officialLanguages;
    }

    public int getNumberOfLanguages() {
        return officialLanguages.length;
    }

    public String getSlug() {
        return slug;
    }

    public String getPopulationString() {
        return populationString;
    }


    private String ConvertToString(int integer) {
        String string = "";
        String intString = Integer.toString(integer);
        int position = 0;
        for (int ii=intString.length()-1; ii>=0; ii--) {
            position++;
            string = intString.charAt(ii) + string;
            if ( (0 == Math.floorMod(position, 3)) && (0 != ii) ) {
                string = "," + string;
            }
        }
        return string;
    }
}
