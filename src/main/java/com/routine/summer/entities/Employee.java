package com.routine.summer.entities;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import com.routine.summer.entities.serialize.OracleDataToString;

import oracle.sql.DATE;

import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
public @Data class Employee {

    private int employeeId;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    @JsonSerialize(using = OracleDataToString.class)
    private DATE hireDate;

    private String jobId;

    private int salary;

    private int commissionPct;

    private int managerId;

    private int departmentId;
}
