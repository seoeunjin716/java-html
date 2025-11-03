package com.seoeunjin.api.user.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.seoeunjin.api.common.domain.Messenger;
import com.seoeunjin.api.user.domain.UserDTO;


@Repository
public class UserRepository {

    public Messenger save(UserDTO user) {
        Messenger messenger = new Messenger();
        return messenger;
    }


    public Messenger saveAll(List<UserDTO> users) {
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

        public Messenger update(UserDTO user) {
            Messenger messenger = new Messenger();
            return messenger;
        }
    
        
        public Messenger delete(String id) {
            Messenger messenger = new Messenger();
            return messenger;
        }
    
        
        public Messenger findById(String id) {
            Messenger messenger = new Messenger();
            return messenger;
        }
    
        
        public Messenger findAll() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'findAll'");
        }
    

}