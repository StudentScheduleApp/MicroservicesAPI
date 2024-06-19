package com.studentscheduleapp.microservicesapi.appapigateway.routes.resourceProviderService.member;

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
public class DeleteMemberRoute implements Routable {
    @Autowired
    private GatewayResourceProviderPathProperties gatewayProperties;
    @Autowired
    private ResourceProviderServiceProperties serviceProperties;

    @Override
    public Function<PredicateSpec, Buildable<Route>> getRoute() {
        return predicateSpec -> predicateSpec.path(gatewayProperties.getDeleteMemberPath())
                .and()
                .method(HttpMethod.DELETE)
                .filters(gatewayFilterSpec -> gatewayFilterSpec.stripPrefix(2)
                        .prefixPath(serviceProperties.getDeleteMemberPath()))
                .uri(serviceProperties.getUri());
    }
}
