package com.routine.summer.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.util.Date;
import javax.persistence.*;

import lombok.Data;
import lombok.NonNull;

@Entity
@Data
@Table(name = "employees")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employee {
    public Employee() {
    }

    @Column(name = "EMPLOYEE_ID", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer employeeId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    @NonNull
    private String lastName;

    @Column(name = "EMAIL")
    @NonNull
    private String email;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "HIRE_Date")
    @JsonSerialize(using = ToStringSerializer.class)
    @NonNull
    private Date hireDate;

    @Column(name = "JOB_ID")
    @NonNull
    private String jobId;

    @Column(name = "SALARY")
    private Float salary;

    @Column(name = "COMMISSION_PCT")
    private Float commissionPct;

    @Column(name = "MANAGER_ID")
    private Integer managerId;

    @Column(name = "DEPARTMENT_ID")
    private Integer departmentId;
}
