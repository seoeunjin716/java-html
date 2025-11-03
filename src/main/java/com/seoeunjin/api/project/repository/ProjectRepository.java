package com.seoeunjin.api.project.repository;

import java.util.List;

import com.seoeunjin.api.common.domain.Messenger;
import com.seoeunjin.api.project.domain.ProjectDTO;

public interface ProjectRepository {

    Messenger printProjectInfo(List<ProjectDTO> projectList);

}
