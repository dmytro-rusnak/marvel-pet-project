package com.rusnak.dim.mapper;

import com.rusnak.dim.dto.HeroDto;
import com.rusnak.dim.entity.HeroEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class HeroMapper extends GenericMapper<HeroEntity, HeroDto> {

  public HeroMapper(ModelMapper modelMapper) {
    super(modelMapper);
  }
}
