package com.cabaleros.weather.forecast.adapter.driven.mapper;

import com.cabaleros.weather.forecast.adapter.driving.model.ForecastResponse;
import com.cabaleros.weather.forecast.application.core.domain.Forecast;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ForecastResponseMapper {

  ForecastResponse map(Forecast forecast);
}
