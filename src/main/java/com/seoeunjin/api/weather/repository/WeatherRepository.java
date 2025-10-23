package com.seoeunjin.api.weather.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.seoeunjin.api.common.domain.Messenger;
import com.seoeunjin.api.weather.domain.WeatherDTO;

@Repository
public class WeatherRepository {
    public Messenger readWeather10(List<WeatherDTO> weathers){
        Messenger messenger = new Messenger();

        System.out.println("=== 날씨 정보 출력 시작 ===");
        System.out.println(); // 빈 줄

        // 10개 데이터 각각 출력
        for (int i = 0; i < weathers.size(); i++) {
            WeatherDTO w = weathers.get(i);  // 변수명 수정: weather → w

            System.out.println((i + 1) + "일차 날씨 정보");
            System.out.println("Date: " + w.getDate());
            System.out.println("Avg Temp: " + w.getAvgTemp() + "°C");
            System.out.println("Max Temp: " + w.getMaxTemp() + "°C");
            System.out.println("Max Temp Time: " + w.getMaxTempTime());
            System.out.println("Min Temp: " + w.getMinTemp() + "°C");
            System.out.println("Min Temp Time: " + w.getMinTempTime());
            System.out.println("Daily Range: " + w.getDailyRange() + "°C");
            System.out.println("Precipitation: " + 
                (w.getPrecipitation() == null || w.getPrecipitation().isEmpty() ? "0.0" : w.getPrecipitation()) + "mm");
            System.out.println("----------------------------------------"); // 구분선
        }

        // 루프 밖에서 한 번만 출력
        System.out.println("===== 상위 10개 날씨 정보 출력 완료 (총 " + weathers.size() + "일) =====");
        System.out.println(); // 가독성
        System.out.flush();

        messenger.setCode(200);
        messenger.setMessage("10개 날씨 정보 출력 성공");

        return messenger;
    }
}
