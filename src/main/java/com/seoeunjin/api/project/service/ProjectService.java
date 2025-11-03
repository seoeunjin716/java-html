package com.seoeunjin.api.project.service;

import java.util.List;

import com.seoeunjin.api.common.domain.Messenger;
import com.seoeunjin.api.project.domain.ProjectDTO;

public interface ProjectService {
    Messenger passToRepository(List<ProjectDTO> dtoList);
}
