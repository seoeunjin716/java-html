package com.seoeunjin.api.auth.controller;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RegisterController {

    @GetMapping("/train/top5")
    public List<Map<String, String>> printTop5Passengers() {
        List<Map<String, String>> passengers = new ArrayList<>();
        try {
            ClassPathResource resource = new ClassPathResource("static/csv/train.csv");
            try (Reader reader = new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)) {
                Iterable<CSVRecord> records = CSVFormat.DEFAULT
                        .builder()
                        .setHeader()
                        .setSkipHeaderRecord(true)
                        .build()
                        .parse(reader);

                int count = 0;
                for (CSVRecord record : records) {
                    Map<String, String> passenger = new HashMap<>();
                    passenger.put("PassengerId", record.get("PassengerId"));
                    passenger.put("Name", record.get("Name"));
                    passenger.put("Sex", record.get("Sex"));
                    passenger.put("Age", record.get("Age"));
                    passenger.put("Pclass", record.get("Pclass"));
                    passenger.put("Survived", record.get("Survived"));
                    passenger.put("SibSp", record.get("SibSp"));
                    passenger.put("Parch", record.get("Parch"));
                    passenger.put("Ticket", record.get("Ticket"));
                    passenger.put("Fare", record.get("Fare"));
                    passenger.put("Cabin", record.get("Cabin"));
                    passenger.put("Embarked", record.get("Embarked"));

                    passengers.add(passenger);

                    // 콘솔에 출력
                    System.out.println(String.format(
                            "Passenger %d: %s (%s, Age: %s, Class: %s, Survived: %s)",
                            count + 1,
                            passenger.get("Name"),
                            passenger.get("Sex"),
                            passenger.get("Age"),
                            passenger.get("Pclass"),
                            passenger.get("Survived")));

                    count++;
                    if (count >= 5) {
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Failed to read train.csv: " + e.getMessage());
            Map<String, String> error = new HashMap<>();
            error.put("error", "Failed to read train.csv: " + e.getMessage());
            passengers.add(error);
        }
        return passengers;
    }
}