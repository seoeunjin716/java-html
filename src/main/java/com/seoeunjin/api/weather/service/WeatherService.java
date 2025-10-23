package com.seoeunjin.api.weather.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.seoeunjin.api.common.domain.Messenger;
import com.seoeunjin.api.weather.domain.WeatherDTO;
import com.seoeunjin.api.weather.repository.WeatherRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WeatherService {
    private final WeatherRepository weatherRepository;
    public Messenger getWeather10(List<WeatherDTO> weathers) {

    Messenger messenger = weatherRepository.readWeather10(weathers);

    return messenger;

    }
}
