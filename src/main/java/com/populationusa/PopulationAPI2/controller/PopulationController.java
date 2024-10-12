package com.populationusa.PopulationAPI2.controller;

import com.populationusa.PopulationAPI2.model.PopulationData;
import com.populationusa.PopulationAPI2.service.PopulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/population")
public class PopulationController {

    private final PopulationService populationService;

    @Autowired
    public PopulationController(PopulationService populationService) {
        this.populationService = populationService;
    }

    @GetMapping("/{year}/{idNation}")
    public PopulationData getPopulationByYearAndId(@PathVariable int year, @PathVariable String idNation) {
        Optional<PopulationData> populationData = populationService.getPopulationByYearAndNation(year, idNation);
        return populationData.orElse(null);
    }

    @GetMapping("/total")
    public long getTotalPopulation() {
        return populationService.getTotalPopulation();
    }

    @GetMapping
    public List<PopulationData> getAllPopulationData() {
        return populationService.getAllPopulationData();
    }
}
