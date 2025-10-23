package com.seoeunjin.api.user.controller;

import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.seoeunjin.api.common.domain.Messenger;
import com.seoeunjin.api.user.domain.UserDTO;
import com.seoeunjin.api.user.service.UserService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user/list")
    public String getUserList(Model model){
        try {
            String csvFilePath = "src/main/resources/static/csv/train.csv";
            // CSV 파일 읽기
            FileReader reader = new FileReader(csvFilePath);
            CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());

            List<UserDTO> users = new ArrayList<>();
            int count = 0;
            
            // 처음 5명의 데이터만 읽기
            for (CSVRecord record : parser) {
                if (count >= 5)
                break;

                    UserDTO user = new UserDTO();
                    user.setUserId(record.get("PassengerId"));
                    user.setName(record.get("Name"));
                    user.setGender(record.get("Sex"));
                    user.setAge(record.get("Age"));
                    user.setPclass(record.get("Pclass"));
                    user.setSurvived(record.get("Survived"));
                    user.setSibSp(record.get("SibSp"));
                    user.setParch(record.get("Parch"));
                    user.setTicket(record.get("Ticket"));
                    user.setFare(record.get("Fare"));
                    user.setCabin(record.get("Cabin"));
                    user.setEmbarked(record.get("Embarked"));

                    users.add(user);

                    count++;
                    

                }
                
                Messenger messenger = userService.getTop5Passengers(users);
                parser.close();
                reader.close();

                model.addAttribute("messenger", messenger);
                model.addAttribute("users", users);


            messenger.setCode(200);
            messenger.setMessage("csv 파일을 성공적으로 읽었습니다. 총 " + users.size() + "명의 데이터를 처리했습니다.");
            return "user/list";

        } catch (Exception e) {
            Messenger messenger = new Messenger();

            messenger.setCode(500);
            messenger.setMessage("csv 파일을 읽는 중 오류가 발생했습니다." + e.getMessage());
            return "user/list";
        }

}}
