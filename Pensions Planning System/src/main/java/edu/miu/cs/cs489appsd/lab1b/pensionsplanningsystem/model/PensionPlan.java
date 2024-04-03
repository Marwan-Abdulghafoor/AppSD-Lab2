package edu.miu.cs.cs489appsd.lab1b.pensionsplanningsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PensionPlan {
    private String planReferenceNumber;
    private Date enrollmentDate;
    private String monthlyContribution;
}
