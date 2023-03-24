package com.dailycodebuffer.Springboot.tutorial.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Table(
        name = "Dept_Table",
        schema = "mydbname",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "dept_code_unique",
                        columnNames = "departmentCode"
                ),
                @UniqueConstraint(
                        name = "dept_mail_unique",
                        columnNames = "departmentEmail"
                )
        }
)

@Entity
public class Department {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "dept_generator"
    )
    @SequenceGenerator(
            name = "dept_generator",
            sequenceName = "dept_sequence_name",
            allocationSize = 1
    )
    private Long departmentId;

    @Column(name = "dept_name", nullable = false)
    private String departName;

    private String departAddress;

    @Column(nullable = false)
    private String departmentCode;
    @Column(nullable = false)
    private String departmentEmail;

    private String university;
    //Here above DEPARTMENT table is created h2 database

    @CreationTimestamp
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    private LocalDateTime lastUpdated;


}
