package com.cabaleros.weather.forecast.util.ratelimit.service.impl;

import com.cabaleros.weather.forecast.util.ratelimit.exception.RateLimitExceeded;
import com.cabaleros.weather.forecast.util.ratelimit.model.Token;
import com.cabaleros.weather.forecast.util.ratelimit.service.RateLimitService;
import jakarta.annotation.PostConstruct;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Data
@Slf4j
@Service
public class RateLimitServiceImpl implements RateLimitService {

  @Getter(AccessLevel.PRIVATE)
  private final Queue<Token> bucket;

  @Value("${weather-forecast.api.rate-limit.capacity}")
  private Integer capacity;

  public RateLimitServiceImpl() {
    bucket = new ConcurrentLinkedQueue<>();
  }

  @PostConstruct
  void postConstruct() {
    refill();
  }

  @Override
  public Token getToken() throws RateLimitExceeded {
    Token token = bucket.poll();

    if (token == null) {
      throw new RateLimitExceeded("There no available tokens in the bucket");
    }

    return token;
  }

  @Override
  public void refill() {
    Integer currentBucketSize = topUp(capacity - bucket.size());
    log.info("[###] Bucket is refilled, current size: {}", currentBucketSize);
  }

  @Override
  public Integer topUp(@NonNull Integer tokensNumber) {
    log.info("[###] Addition of {} tokens is requested", tokensNumber);

    if (tokensNumber <= 0 || tokensNumber > capacity) {
      throw new IllegalArgumentException("The request number of tokens either is negative or exceeds the capacity: "
          + tokensNumber);
    }

    int i;
    for (i = 0; i < tokensNumber; i++) {
      if (bucket.size() >= capacity) {
        break;
      }

      bucket.add(new Token());
    }

    log.info("[###] Added to the bucket {} tokens", i);

    return bucket.size();
  }
}
