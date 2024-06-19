package com.studentscheduleapp.microservicesapi.appapigateway.global;

import com.studentscheduleapp.microservicesapi.appapigateway.properties.GlobalProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class TokenRequestHeaderFilter implements GlobalFilter {
    @Autowired
    private GlobalProperties globalProperties;
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest mutatedServerRequest = exchange.getRequest().mutate()
                .header(globalProperties.getServiceTokenHeader(),globalProperties.getServiceToken()).build();
        ServerWebExchange mutataedExchange = exchange.mutate().request(mutatedServerRequest).build();
        return chain.filter(mutataedExchange);
    }
    @Bean
    public GlobalFilter tokenRequestHeaderFilterBean(){
        return new TokenRequestHeaderFilter();
    }
}
