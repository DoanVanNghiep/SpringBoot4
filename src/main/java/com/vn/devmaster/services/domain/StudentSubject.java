package com.vn.devmaster.services.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student_subject")
public class StudentSubject {
    @EmbeddedId
    private StudentSubjectId id;

    @MapsId("idStudent")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_student", nullable = false)
    private Student idStudent;

    @MapsId("idSubject")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_subject", nullable = false)
    private Subject idSubject;

    @Column(name = "point")
    private Integer point;

}