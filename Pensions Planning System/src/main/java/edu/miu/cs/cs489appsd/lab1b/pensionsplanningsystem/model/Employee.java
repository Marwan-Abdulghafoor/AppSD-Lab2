package edu.miu.cs.cs489appsd.lab1b.pensionsplanningsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@Data
@AllArgsConstructor
public class Employee {
    private long employeeId;
    private String firstName;
    private String lastName;
    private Date employmentDate;
    private String yearlySalary;

}
