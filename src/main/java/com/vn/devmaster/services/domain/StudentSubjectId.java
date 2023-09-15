package com.vn.devmaster.services.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class StudentSubjectId{
    private static final long serialVersionUID = -3011089968732327314L;
    @Column(name = "id_student", nullable = false)
    private Integer idStudent;

    @Column(name = "id_subject", nullable = false)
    private Integer idSubject;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        StudentSubjectId entity = (StudentSubjectId) o;
        return Objects.equals(this.idSubject, entity.idSubject) &&
                Objects.equals(this.idStudent, entity.idStudent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSubject, idStudent);
    }

}