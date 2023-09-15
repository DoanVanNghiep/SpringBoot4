package com.vn.devmaster.services.dto;

import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link com.vn.devmaster.services.domain.Subject}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder
@Value
public class SubjectDto{
    Integer id;
    String name;
}