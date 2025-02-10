package com.cabaleros.weather.forecast.application.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Value {

  private Double value;
  private String units;
}
