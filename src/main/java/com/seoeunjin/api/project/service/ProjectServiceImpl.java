package com.seoeunjin.api.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.seoeunjin.api.common.domain.Messenger;
import com.seoeunjin.api.project.domain.ProjectDTO;
import com.seoeunjin.api.project.repository.ProjectRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Override
    public Messenger passToRepository(List<ProjectDTO> dtoList) {
        System.out.println("\n[ProjectService] passToRepository() 호출");
        System.out.println("  받은 데이터: " + dtoList.size() + "개의 DTO");
        System.out.println("  → Repository로 전달\n");

        // Repository의 printProjectInfo 메서드 호출 (파이프라인)
        Messenger messenger = projectRepository.printProjectInfo(dtoList);

        System.out.println("[ProjectService] Repository로부터 Messenger 수신 완료\n");
        return messenger;
    }
}
