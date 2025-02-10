package com.cabaleros.weather.forecast.application.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InstantForecast {

  private Value airTemperature;
  private Value windSpeed;
}
