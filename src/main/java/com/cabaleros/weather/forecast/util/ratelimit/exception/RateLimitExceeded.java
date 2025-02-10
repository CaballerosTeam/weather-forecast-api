package com.cabaleros.weather.forecast.util.ratelimit.exception;

public class RateLimitExceeded extends Exception {

  public RateLimitExceeded(String message) {
    super(message);
  }
}
