package com.studentscheduleapp.microservicesapi.databaseservice.data.tablemodels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "outline_medias")
public class OutlineMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "timestamp", nullable = false)
    private long timestamp;
    @Column(name = "outline_id", nullable = false)
    private long outlineId;
    @Column(name = "image_url", nullable = false)
    private String imageUrl;

}
