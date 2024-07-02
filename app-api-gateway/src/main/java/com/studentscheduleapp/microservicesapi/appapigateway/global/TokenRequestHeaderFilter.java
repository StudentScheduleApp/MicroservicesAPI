package com.studentscheduleapp.microservicesapi.appapigateway.global;

import com.studentscheduleapp.microservicesapi.appapigateway.properties.GlobalProperties;
import com.studentscheduleapp.microservicesapi.appapigateway.services.VersionCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class TokenRequestHeaderFilter implements GlobalFilter {
    @Autowired
    private GlobalProperties globalProperties;
    @Autowired
    private VersionCheckService versionCheckService;
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest mutatedServerRequest = exchange.getRequest().mutate()
                .header(globalProperties.getServiceTokenHeader(),globalProperties.getServiceToken()).build();
        ServerWebExchange mutataedExchange = exchange.mutate().request(mutatedServerRequest).build();
        if(!mutatedServerRequest.getHeaders().get(globalProperties.getClientTokenHeader()).isEmpty() && !mutatedServerRequest.getHeaders().get(globalProperties.getClientTokenHeader()).get(0).equals(globalProperties.getClientToken())) {
            exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
            return Mono.empty();
        }
        try {
            if(!mutatedServerRequest.getHeaders().get(globalProperties.getClientVersionHeader()).isEmpty() && !versionCheckService.isAfterOrEqualsVersion(mutatedServerRequest.getHeaders().get(globalProperties.getClientVersionHeader()).get(0), globalProperties.getClientVersion())) {
                exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
                return Mono.empty();
            }
        } catch (Exception e) {
            exchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);
            return Mono.empty();
        }
        return chain.filter(mutataedExchange);
    }
    @Bean
    public GlobalFilter tokenRequestHeaderFilterBean(){
        return new TokenRequestHeaderFilter();
    }

}
