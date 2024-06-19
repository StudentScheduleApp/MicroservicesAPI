package com.studentscheduleapp.microservicesapi.identityservice.models.api;

import com.studentscheduleapp.microservicesapi.identityservice.models.AuthorizeType;
import com.studentscheduleapp.microservicesapi.identityservice.models.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorizeEntity {
    private AuthorizeType type;
    private List<Long> ids;
    private Entity entity;
    private List<String> params;
}
