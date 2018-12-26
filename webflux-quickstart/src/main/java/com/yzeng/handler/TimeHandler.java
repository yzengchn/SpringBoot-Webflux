package com.yzeng.handler;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class TimeHandler {
	
	/**
	 * MediaType.TEXT_EVENT_STREAM表示Content-Type为text/event-stream，即SSE
	 *  利用interval生成每秒一个数据的流
	 * @author <a href="http://www.yzblog.xyz">yzblog</a>
	 * @date 2018年12月26日 上午10:57:43
	 * @title sendTimeMsg
	 * @param request
	 * @return Mono<ServerResponse>
	 */
	public Mono<ServerResponse> sendTimeMsg(ServerRequest request){
		return ServerResponse
				.ok()
				.contentType(MediaType.TEXT_EVENT_STREAM)
				.body(Flux.interval(Duration.ofSeconds(3)).map(mapper -> "task:"+new SimpleDateFormat("HH:mm:ss").format(new Date())),String.class);
	}
	
	public Mono<ServerResponse> getCurrentTime(ServerRequest request){
		return ServerResponse
			    .ok()
			    .contentType(MediaType.TEXT_PLAIN)
			    .body(Mono.just("现在时间："+ new SimpleDateFormat("HH:mm:ss").format(new Date())),String.class);
	}
	
	public Mono<ServerResponse> getCurrentDate(ServerRequest request){
		return ServerResponse
			    .ok()
			    .contentType(MediaType.TEXT_PLAIN)
			    .body(Mono.just("今天是："+ new SimpleDateFormat("yyyy-MM-dd").format(new Date())),String.class);
	}
}
