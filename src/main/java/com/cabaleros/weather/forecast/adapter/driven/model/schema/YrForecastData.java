package com.cabaleros.weather.forecast.adapter.driven.model.schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class YrForecastData {

  private YrInstantForecastDetails instant;

  @JsonProperty("next_1_hours")
  private YrNHoursForecastDetails next1Hour;

  @JsonProperty("next_6_hours")
  private YrNHoursForecastDetails next6Hours;

  @JsonProperty("next_12_hours")
  private YrNHoursForecastDetails next12Hours;
}
