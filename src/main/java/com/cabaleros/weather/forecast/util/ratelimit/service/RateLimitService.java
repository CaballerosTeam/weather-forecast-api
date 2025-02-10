package com.cabaleros.weather.forecast.util.ratelimit.service;

import com.cabaleros.weather.forecast.util.ratelimit.exception.RateLimitExceeded;
import com.cabaleros.weather.forecast.util.ratelimit.model.Token;

public interface RateLimitService {

  Token getToken() throws RateLimitExceeded;

  Integer topUp(Integer tokensNumber);

  void refill();
}
