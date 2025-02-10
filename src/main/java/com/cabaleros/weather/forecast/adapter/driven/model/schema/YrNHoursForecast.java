package com.cabaleros.weather.forecast.adapter.driven.model.schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class YrNHoursForecast {

  @JsonProperty("air_temperature_min")
  private Double airTemperatureMin;

  @JsonProperty("air_temperature_max")
  private Double airTemperatureMax;
}
