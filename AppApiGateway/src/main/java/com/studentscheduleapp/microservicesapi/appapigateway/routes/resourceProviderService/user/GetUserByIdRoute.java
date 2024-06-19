package com.studentscheduleapp.microservicesapi.appapigateway.routes.resourceProviderService.user;

import com.studentscheduleapp.microservicesapi.appapigateway.interfaces.Routable;
import com.studentscheduleapp.microservicesapi.appapigateway.properties.gateway.GatewayResourceProviderPathProperties;
import com.studentscheduleapp.microservicesapi.appapigateway.properties.service.ResourceProviderServiceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class GetUserByIdRoute implements Routable {
    @Autowired
    GatewayResourceProviderPathProperties gatewayProperties;
    @Autowired
    ResourceProviderServiceProperties serviceProperties;
    @Override
    public Function<PredicateSpec, Buildable<Route>> getRoute() {
        return predicateSpec -> predicateSpec.path(gatewayProperties.getGetUserByIdPath())
                .and()
                .method(HttpMethod.GET)
                .filters(gatewayFilterSpec -> gatewayFilterSpec.stripPrefix(2)
                        .prefixPath(serviceProperties.getGetUserByIdPath()))
                .uri(serviceProperties.getUri());
    }
}
