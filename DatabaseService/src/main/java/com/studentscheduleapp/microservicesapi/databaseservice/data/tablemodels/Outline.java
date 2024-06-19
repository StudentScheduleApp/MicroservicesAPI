package com.studentscheduleapp.microservicesapi.databaseservice.data.tablemodels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "outlines")
public class Outline {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "user_id", nullable = false)
    private long userId;
    @Column(name = "specific_lesson_id", nullable = false)
    private long specificLessonId;

}
