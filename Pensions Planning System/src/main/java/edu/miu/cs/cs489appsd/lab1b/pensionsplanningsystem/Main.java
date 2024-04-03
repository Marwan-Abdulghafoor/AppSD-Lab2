package edu.miu.cs.cs489appsd.lab1b.pensionsplanningsystem;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.miu.cs.cs489appsd.lab1b.pensionsplanningsystem.model.Employee;
import edu.miu.cs.cs489appsd.lab1b.pensionsplanningsystem.model.EmployeeWithPlan;
import edu.miu.cs.cs489appsd.lab1b.pensionsplanningsystem.model.PensionPlan;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<EmployeeWithPlan> employees = new ArrayList<>();


        Employee employee = new Employee(1l, "Daniel", "Agar", new Date(2018, 00, 17), "105,945.50");
        PensionPlan pensionPlan = new PensionPlan("EX1089", new Date(123, 00, 17), "$100.00");
        EmployeeWithPlan employeeWithPlan = new EmployeeWithPlan(employee, pensionPlan);
        employees.add(employeeWithPlan);

        employee = new Employee(2l, "Benard", "Shaw", new Date(119, 03, 03), "197,750.00");
        pensionPlan = new PensionPlan();
        employeeWithPlan = new EmployeeWithPlan(employee, pensionPlan);
        employees.add(employeeWithPlan);

        employee = new Employee(3l, "Carly", "Agar", new Date(114, 04, 16), "842,000.75");
        pensionPlan = new PensionPlan("SM2307", new Date(2019, 10, 04), "$1,555.50");
        employeeWithPlan = new EmployeeWithPlan(employee, pensionPlan);
        employees.add(employeeWithPlan);

        employee = new Employee(4l, "Wesley", "Schneider", new Date(119, 04, 02), "74,500.00");
        pensionPlan = new PensionPlan();
        employeeWithPlan = new EmployeeWithPlan(employee, pensionPlan);
        employees.add(employeeWithPlan);

        printEmployeesJSON(employees);
        printNextMonthEnrolleesReport(employees);
    }

    private static void printNextMonthEnrolleesReport(ArrayList<EmployeeWithPlan> employees) {


        Date lastDateOfNextMonth = new Date(125, 04, 31);


        Collections.sort(employees, new Comparator<EmployeeWithPlan>() {
            @Override
            public int compare(EmployeeWithPlan o1, EmployeeWithPlan o2) {
                return o1.getEmployee().getEmploymentDate().compareTo(o2.getEmployee().getEmploymentDate());
            }
        });

        List<Employee> employeeArrayList = employees.stream().filter(employeeWithPlan -> employeeWithPlan.getPensionPlan().getPlanReferenceNumber() == null)
                .map(employeeWithPlan -> employeeWithPlan.getEmployee())
                .filter(employee -> (employee.getEmploymentDate().getMonth() == (lastDateOfNextMonth.getMonth()) && employee.getEmploymentDate().getDate() <= (lastDateOfNextMonth.getDate()))
                        || (employee.getEmploymentDate().getMonth() < (lastDateOfNextMonth.getMonth())))
                .collect(Collectors.toList());

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(employeeArrayList);
        System.out.println("The data of the Monthly Upcoming Enrollees report, in JSON format:");
        System.out.println(json);
    }

    private static void printEmployeesJSON(ArrayList<EmployeeWithPlan> employees) {
        Collections.sort(employees, new Comparator<EmployeeWithPlan>() {
            @Override
            public int compare(EmployeeWithPlan o1, EmployeeWithPlan o2) {
                int byName = o1.getEmployee().getLastName().compareTo(o2.getEmployee().getLastName());
                if (byName != 0) {
                    return byName;
                }

                return o2.getEmployee().getYearlySalary().compareTo(o1.getEmployee().getYearlySalary());

            }
        });

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(employees);
        System.out.println("The list of all the Employees in JSON format:");
        System.out.println(json);
    }
}
