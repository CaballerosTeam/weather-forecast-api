package com.cabaleros.weather.forecast.adapter.driven.model.schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class YrInstantForecast {

  @JsonProperty("air_temperature")
  private Double airTemperature;

  @JsonProperty("wind_speed")
  private Double windSpeed;
}
