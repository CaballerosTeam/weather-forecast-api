package com.cabaleros.weather.forecast.adapter.driven.model.schema;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class YrForecastTimeStep {

  private YrForecastData data;
  private Instant time;
}
