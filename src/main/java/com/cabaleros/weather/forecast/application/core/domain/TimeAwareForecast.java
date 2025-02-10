package com.cabaleros.weather.forecast.application.core.domain;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeAwareForecast {

  private Instant timestamp;
  private InstantForecast instant;
  private PeriodForecast next1Hour;
  private PeriodForecast next6Hours;
  private PeriodForecast next12Hours;
}
