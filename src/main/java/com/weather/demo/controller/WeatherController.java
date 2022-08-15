package com.weather.demo.controller;


import com.weather.demo.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class WeatherController {

    @Value("${apikey}")
    private String apiKey;

    @GetMapping("/weather/{zipCode}")
    public Object getWeather(@PathVariable("zipCode") long id){
        String url = "http://api.weatherapi.com/v1/forecast.json?key="+apiKey+"&q="+id+"&aqi=no";

        RestTemplate restTemplate = new RestTemplate();

        Object weather = restTemplate.getForObject(url, Object.class);
        if(weather == null){
            throw new ObjectNotFoundException("Could not find weather for zipCode:" + id);
        }

        return weather;

    }
}
