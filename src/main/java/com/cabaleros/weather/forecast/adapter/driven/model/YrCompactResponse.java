package com.cabaleros.weather.forecast.adapter.driven.model;

import com.cabaleros.weather.forecast.adapter.driven.model.schema.YrProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class YrCompactResponse {

  private YrProperties properties;
}
