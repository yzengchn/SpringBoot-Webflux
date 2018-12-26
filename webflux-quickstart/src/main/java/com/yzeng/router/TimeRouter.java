package com.yzeng.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.yzeng.handler.TimeHandler;

@Configuration
public class TimeRouter {

	@Bean
    public RouterFunction<ServerResponse> routeCity(TimeHandler timeHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/time")
                                .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
                                timeHandler::getCurrentTime)
                .andRoute(RequestPredicates.GET("/date")
                				.and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
                				timeHandler::getCurrentDate)
		        .andRoute(RequestPredicates.GET("/send")
								.and(RequestPredicates.accept(MediaType.TEXT_EVENT_STREAM)),
								timeHandler::sendTimeMsg);
    }
}
