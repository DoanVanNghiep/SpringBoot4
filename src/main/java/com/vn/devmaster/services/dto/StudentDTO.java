package com.vn.devmaster.services.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class StudentDTO {

    private Integer id;

    private String fullName;

    private String firstName;
    private String lastName;
    private String aClass;
    private int point;
    private AddressDto addressDto;
    private List<SubjectDto> subjectDtos;
    private ClassDto classDto;
    private StudentSubjectDto studentSubjectDtos;

}
