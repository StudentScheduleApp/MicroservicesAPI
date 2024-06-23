package com.studentscheduleapp.microservicesapi.databaseservice.data.tablemodels;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "chat_id", nullable = false)
    private long chatId;
    @Column(name = "ava_url")
    private String avaUrl;
    @Column(name = "name", nullable = false)
    private String name;

}
