package swiggy_app_gateway.swiggy_app_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SwiggyAppGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwiggyAppGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("CUSTOMER-API", r -> r.path("/customer/**")
                        .uri("lb://CUSTOMER-API"))
                .route("DELIVERY-API", r -> r.path("/delivery/**")
                        .uri("lb://DELIVERY-API"))
                .route("HOTEL-API", r -> r.path("/hotel-api/**")
                        .uri("lb://HOTEL-API"))
                .route("ORDER-API", r -> r.path("/order/**")
                        .uri("lb://ORDER-API"))
                .route("PAYMENT-API", r -> r.path("/payment/**")
                        .uri("lb://PAYMENT-API"))
                .build();
    }


}
