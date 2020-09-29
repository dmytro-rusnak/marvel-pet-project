package com.rusnak.dim.mapper;

import org.modelmapper.ModelMapper;

import java.lang.reflect.ParameterizedType;

public abstract class GenericMapper<K, T> {

  private final ModelMapper modelMapper;
  private final Class<K> entityClass;
  private final Class<T> dtoClass;

  public GenericMapper(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
    this.entityClass = getEntityClass();
    this.dtoClass = getDtoClass();
  }

  @SuppressWarnings("unchecked")
  private Class<K> getEntityClass() {
    return (Class<K>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
  }

  @SuppressWarnings("unchecked")
  private Class<T> getDtoClass() {
    return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
  }

  public T mapEntityToDto(K entity) {
    return modelMapper.map(entity, dtoClass);
  }

  public K mapDtoToEntity(T dto) {
    return modelMapper.map(dto, entityClass);
  }

}
