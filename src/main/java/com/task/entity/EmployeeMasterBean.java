package com.task.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "EMPLOYEE_MASTER_BEAN")
public class EmployeeMasterBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLOYEE_ID", columnDefinition = "BIGINT") // Column name in uppercase
    private Integer employeeId; // Change type to Long if you use auto-generated IDs

    @Pattern(regexp = "^[A-Za-z]+$", message = "First Name must contain only alphabetical values")
    @Column(name = "FIRST_NAME", columnDefinition = "VARCHAR(50)") // Column name in uppercase
    private String firstName;

    @Pattern(regexp = "^[A-Za-z]*$", message = "Last Name must contain only alphabetical values or be empty")
    @Column(name = "LAST_NAME", columnDefinition = "VARCHAR(50)") // Column name in uppercase
    private String lastName;

    @NotNull(message = "Date of Birth is mandatory")
    @Column(name = "DATE_OF_BIRTH", columnDefinition = "DATE") // Column name in uppercase
    private LocalDate dateOfBirth; // Use LocalDate for date representation

    @Pattern(regexp = "[MF]?", message = "Gender must be 'M', 'F' or empty")
    @Column(name = "GENDER", columnDefinition = "CHAR(1)") // Column name in uppercase
    private String gender;

    @Pattern(regexp = "^[A-Za-z]*$", message = "Nationality must contain only alphabetical values or be empty")
    @Column(name = "NATIONALITY", columnDefinition = "VARCHAR(50)") // Column name in uppercase
    private String nationality;

    @Size(max = 30, message = "Address must not exceed 30 characters")
    @Column(name = "ADDRESS", columnDefinition = "VARCHAR(30)") // Column name in uppercase
    private String address;

    @NotNull(message = "Contact Number is mandatory")
    @Pattern(regexp = "^\\+[1-9]\\d{1}\\d{10}$", message = "Contact Number must start with '+' followed by a 2-digit country code and exactly 10 digits")
    @Column(name = "CONTACT_NUMBER", columnDefinition = "VARCHAR(15)") // Column name in uppercase
    private String contactNumber;

    @NotNull(message = "Department is mandatory")
    @Size(min = 1, message = "Department cannot be empty")
    @Column(name = "DEPARTMENT", columnDefinition = "VARCHAR(50)") // Column name in uppercase
    private String department;

    @NotNull(message = "Position/Job Title is mandatory")
    @Size(min = 1, message = "Position/Job Title cannot be empty")
    @Column(name = "JOB_TITLE", columnDefinition = "VARCHAR(50)") // Column name in uppercase
    private String jobTitle;
    
    @Column(name = "FLAG")
    private String flag;
  

    // Getters and Setters are automatically generated by Lombok
}
