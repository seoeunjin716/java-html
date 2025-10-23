package com.seoeunjin.api.weather.controller;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;  // 이거만 남기기

import com.seoeunjin.api.common.domain.Messenger;
import com.seoeunjin.api.weather.domain.WeatherDTO;
import com.seoeunjin.api.weather.service.WeatherService;

import lombok.RequiredArgsConstructor;

@RestController  // ← @Controller 삭제, 이거 하나만!
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/weather")
    public Messenger printWeather10() {
        Messenger messenger = new Messenger();  // 미리 생성

        try {
            // classpath 기준: src/main/resources/static/csv/train_weather.csv
            String csvFilePath = "src/main/resources/static/csv/train_weather.csv";

            FileReader reader = new FileReader(csvFilePath);
            CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader(
                "일시", "평균기온(℃)", "최고기온(℃)", "최고기온시각",
                "최저기온(℃)", "최저기온시각", "일교차", "강수량(mm)"
        )
        .withFirstRecordAsHeader().withTrim()
);

            List<WeatherDTO> weathers = new ArrayList<>();
            int count = 0;

            for (CSVRecord record : parser) {
                if (count >= 10) break;

                System.out.println(count + "번째 실행");  // 확인용

                WeatherDTO weather = new WeatherDTO();
                weather.setDate(record.get("일시"));
                weather.setAvgTemp(record.get("평균기온(℃)"));
                weather.setMaxTemp(record.get("최고기온(℃)"));
                weather.setMaxTempTime(record.get("최고기온시각"));
                weather.setMinTemp(record.get("최저기온(℃)"));
                weather.setMinTempTime(record.get("최저기온시각"));
                weather.setDailyRange(record.get("일교차"));
                weather.setPrecipitation(record.get("강수량(mm)"));

                weathers.add(weather);
                count++;
            }

            parser.close();
            reader.close();

            // 서비스 → 레포지토리 → 터미널 출력
            Messenger result = weatherService.getWeather10(weathers);

            // result가 null이 아니라고 가정하고 사용
            messenger.setCode(result.getCode());
            messenger.setMessage("CSV 파일을 성공적으로 읽었습니다. 총 " + weathers.size() + "건 처리됨.");

            return messenger;

        } catch (Exception e) {
            e.printStackTrace();
            messenger.setCode(500);
            messenger.setMessage("CSV 파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
            return messenger;
        }
    }
}