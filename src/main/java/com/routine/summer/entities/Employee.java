package com.routine.summer.entities;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.routine.summer.entities.serialize.OracleDataToString;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import oracle.sql.DATE;

@Builder(toBuilder = true)
public @Value class Employee {

    private int employeeId;

    private String firstName;

    @NonNull private String lastName;

    @NonNull private String email;

    private String phoneNumber;

    @NonNull
    @JsonSerialize(using = OracleDataToString.class)
    private DATE hireDate;

    @NonNull private String jobId;

    private int salary;

    private int commissionPct;

    private int managerId;

    private int departmentId;
}
