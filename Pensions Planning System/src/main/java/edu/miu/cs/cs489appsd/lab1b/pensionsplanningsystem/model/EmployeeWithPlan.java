package edu.miu.cs.cs489appsd.lab1b.pensionsplanningsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeWithPlan {
    private Employee employee;
    private PensionPlan pensionPlan;
}
