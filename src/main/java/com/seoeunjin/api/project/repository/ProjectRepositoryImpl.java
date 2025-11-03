package com.seoeunjin.api.project.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.seoeunjin.api.common.domain.Messenger;
import com.seoeunjin.api.project.domain.ProjectDTO;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository {

    @Override
    public Messenger printProjectInfo(List<ProjectDTO> projectList) {
        Messenger messenger = new Messenger();
        System.out.println("\n===== Project 배출량 정보 출력 시작 =====");

        for (ProjectDTO project : projectList) {
            System.out.println(
                    "사이트: " + project.getSite() +
                            ", Scope 1: " + project.getScope1Tco2e() +
                            ", Scope 2: " + project.getScope2Tco2e() +
                            ", Total Scope 1+2: " + project.getTotalScope12Tco2e() +
                            ", Scope 3: " + project.getScope3Tco2e());
        }

        System.out.println("===== Project 배출량 정보 출력 완료 (총 " + projectList.size() + "개) =====\n");
        System.out.flush();

        messenger.setCode(200);
        messenger.setMessage("입력 성공");

        return messenger;
    }
}
