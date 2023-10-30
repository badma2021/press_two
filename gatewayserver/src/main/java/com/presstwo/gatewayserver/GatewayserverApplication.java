package com.presstwo.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayserverApplication.class, args);
	}

	@Bean
	public RouteLocator pressTwoRouteConfig(RouteLocatorBuilder routeLocatorBuilder){
		return routeLocatorBuilder.routes()
				.route(p->p
						.path("/presstwo/input/**")
						.filters(f->f
								.rewritePath("/presstwo/input/(?<segment>.*)","/${segment}"))
						.uri("lb://INPUT"))
				.route(p->p
						.path("/presstwo/stata/**")
						.filters(f->f
								.rewritePath("/presstwo/stata/(?<segment>.*)","/${segment}"))
						.uri("lb://STATA"))
				.build();
	}



}
