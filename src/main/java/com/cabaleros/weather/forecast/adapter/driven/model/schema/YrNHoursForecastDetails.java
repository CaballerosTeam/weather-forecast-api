package com.cabaleros.weather.forecast.adapter.driven.model.schema;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class YrNHoursForecastDetails {

  private YrNHoursForecast details;
  private YrForecastSummary summary;
}
