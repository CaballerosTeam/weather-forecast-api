package com.cabaleros.weather.forecast.application.core.domain;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Forecast {

  private List<TimeAwareForecast> timeseries;
}
