package com.populationusa.PopulationAPI2.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PopulationData {
    @JsonProperty("ID Nation")
    private String idNation;
    @JsonProperty("Nation")
    private String nation;
    @JsonProperty("ID Year")
    private int idYear;
    @JsonProperty("Year")
    private String year;
    @JsonProperty("Population")
    private long population;
    @JsonProperty("Slug Nation")
    private String slugNation;

    // Getters and setters
    public String getIdNation() {
        return idNation;
    }

    public void setIdNation(String idNation) {
        this.idNation = idNation;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public int getIdYear() {
        return idYear;
    }

    public void setIdYear(int idYear) {
        this.idYear = idYear;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String getSlugNation() {
        return slugNation;
    }

    public void setSlugNation(String slugNation) {
        this.slugNation = slugNation;
    }
}
