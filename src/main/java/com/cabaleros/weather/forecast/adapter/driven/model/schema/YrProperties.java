package com.cabaleros.weather.forecast.adapter.driven.model.schema;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class YrProperties {

  private List<YrForecastTimeStep> timeseries;
}
