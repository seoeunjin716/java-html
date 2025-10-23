package com.seoeunjin.api.user.repository;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Repository;

import com.seoeunjin.api.common.domain.Messenger;
import com.seoeunjin.api.user.domain.UserDTO;

@Repository
public class UserRepository {

    public Messenger readTop5Passengers(List<UserDTO> users) {
        Messenger messenger = new Messenger();
        System.out.println("===== Top 5 승객 정보 출력 시작 =====");

        for (UserDTO user : users){
            System.out.println(
                    "승객 ID: " + user.getUserId() +
                    ", 이름: " + user.getName() +
                    ", 성별: " + user.getGender() +
                    ", 나이: " + user.getAge() +
                    ", Pclass: " + user.getPclass() +
                    ", 생존여부: " + user.getSurvived() +
                    ", 요금: " + user.getFare()
            );
            System.out.println("===== Top 5 승객 정보 출력 완료 (총 " + users.size() + "명) =====");
            System.out.flush();
        }

    messenger.setCode(200);
    messenger.setMessage("입력 성공");

    return messenger;
        }

}