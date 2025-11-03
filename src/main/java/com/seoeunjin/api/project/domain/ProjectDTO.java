package com.seoeunjin.api.project.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {
    private String site;
    private Double scope1Tco2e;
    private Double scope2Tco2e;
    private Double totalScope12Tco2e;
    private Double scope3Tco2e;

}
