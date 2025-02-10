package com.cabaleros.weather.forecast.util.ratelimit.model;

import java.time.Instant;
import java.util.UUID;

public record Token(UUID uuid, Instant createdAt) {

  public Token() {
    this(UUID.randomUUID(), Instant.now());
  }
}
