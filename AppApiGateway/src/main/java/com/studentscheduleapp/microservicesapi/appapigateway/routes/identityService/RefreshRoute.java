package com.studentscheduleapp.microservicesapi.appapigateway.routes.identityService;

import com.studentscheduleapp.microservicesapi.appapigateway.interfaces.Routable;
import com.studentscheduleapp.microservicesapi.appapigateway.properties.GlobalProperties;
import com.studentscheduleapp.microservicesapi.appapigateway.properties.gateway.GatewayIdentityPathProperties;
import com.studentscheduleapp.microservicesapi.appapigateway.properties.service.IdentityServiceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RefreshRoute implements Routable {
    @Autowired
    private GlobalProperties globalProperties;
    @Autowired
    private IdentityServiceProperties identityServiceProperties;
    @Autowired
    private GatewayIdentityPathProperties gatewayIdentityPathProperties;
    @Override
    public Function<PredicateSpec, Buildable<Route>> getRoute() {
        return predicateSpec -> predicateSpec.path(gatewayIdentityPathProperties.getRefreshPath())
                .and()
                .method(HttpMethod.POST)
                .filters(gatewayFilterSpec -> gatewayFilterSpec.stripPrefix(2)
                        .prefixPath(identityServiceProperties.getRefreshPath()))
                .uri(identityServiceProperties.getUri());
    }
}
