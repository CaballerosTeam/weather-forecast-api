package com.cabaleros.weather.forecast.util.ratelimit.job;

import com.cabaleros.weather.forecast.util.ratelimit.service.RateLimitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RateLimitBucketJob {

  private final RateLimitService rateLimitService;

  @Value("${weather-forecast.api.rate-limit.max-rate}")
  private Integer maxRate;

  @Value("${weather-forecast.api.rate-limit.capacity}")
  private Integer capacity;

  @Scheduled(fixedDelay = 500)
  public void topUpRateLimitBucket() {
    log.info("[###] Checking if rate limit bucket should be top up");
    Integer tokensNumber = capacity / maxRate;
    Integer currentBucketSize = rateLimitService.topUp(tokensNumber);
    log.info("[###] Bucket is top up, current size: {}", currentBucketSize);
  }
}
