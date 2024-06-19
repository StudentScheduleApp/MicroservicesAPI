package com.studentscheduleapp.microservicesapi.appapigateway.routes.resourceProviderService.specificLesson;

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
public class CreateSpecificLessonRoute implements Routable {
    @Autowired
    private ResourceProviderServiceProperties serviceProperties;
    @Autowired
    private GatewayResourceProviderPathProperties gatewayResourceProviderPathProperties;

    @Override
    public Function<PredicateSpec, Buildable<Route>> getRoute() {
        return predicateSpec -> predicateSpec.path(gatewayResourceProviderPathProperties.getCreateSpecificLessonPath())
                .and()
                .method(HttpMethod.POST)
                .filters(gatewayFilterSpec -> gatewayFilterSpec.stripPrefix(2)
                        .prefixPath(serviceProperties.getCreateSpecificLessonPath()))
                .uri(serviceProperties.getUri());
    }
}
