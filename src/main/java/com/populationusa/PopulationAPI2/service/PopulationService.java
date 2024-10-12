package com.populationusa.PopulationAPI2.service;

import com.populationusa.PopulationAPI2.model.PopulationData;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class PopulationService {
    private static final Logger LOGGER = Logger.getLogger(PopulationService.class.getName());

    private List<PopulationData> fetchPopulationData() {
        String url = "https://datausa.io/api/data?drilldowns=Nation&measures=Population";
        RestTemplate restTemplate = new RestTemplate();
        try {
            PopulationResponse response = restTemplate.getForObject(url, PopulationResponse.class);
            if (response != null) {
                return Arrays.asList(response.getData());
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error fetching population data", e);
        }
        return List.of();
    }

    public List<PopulationData> getAllPopulationData() {
        return fetchPopulationData();
    }

    public Optional<PopulationData> getPopulationByYearAndNation(int year, String idNation) {
        return fetchPopulationData().stream()
                .filter(data -> data.getIdYear() == year && data.getIdNation().equals(idNation))
                .findFirst();
    }

    public long getTotalPopulation() {
        return fetchPopulationData().stream()
                .mapToLong(PopulationData::getPopulation)
                .sum();
    }

    private static class PopulationResponse {
        private PopulationData[] data;

        public PopulationData[] getData() {
            return data;
        }

        public void setData(PopulationData[] data) {
            this.data = data;
        }
    }
}
