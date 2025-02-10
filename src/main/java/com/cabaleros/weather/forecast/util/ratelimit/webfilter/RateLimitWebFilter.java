package com.cabaleros.weather.forecast.util.ratelimit.webfilter;

import com.cabaleros.weather.forecast.util.ratelimit.exception.RateLimitExceeded;
import com.cabaleros.weather.forecast.util.ratelimit.model.Token;
import com.cabaleros.weather.forecast.util.ratelimit.service.RateLimitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class RateLimitWebFilter implements WebFilter {

  private final RateLimitService rateLimitService;

  @Override
  public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
    Token token;

    try {
      token = rateLimitService.getToken();
    } catch (RateLimitExceeded e) {
      log.debug("[!] Rate limit exceeded");
      ServerHttpResponse response = exchange.getResponse();
      response.setStatusCode(HttpStatus.TOO_MANY_REQUESTS);
      return response.setComplete();
    }

    exchange.getRequest().mutate()
        .header("X-Request-ID", token.uuid().toString());

    return chain.filter(exchange);
  }
}
