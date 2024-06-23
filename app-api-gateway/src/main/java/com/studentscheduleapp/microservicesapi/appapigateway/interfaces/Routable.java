package com.studentscheduleapp.microservicesapi.appapigateway.interfaces;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;

import java.util.function.Function;

public interface Routable {
    Function<PredicateSpec, Buildable<Route>> getRoute();
}
