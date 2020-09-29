package com.rusnak.dim.dto;

import java.util.Objects;

public class HeroDto implements IDto{

  private String name;
  private String description;
  private Integer rank;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getRank() {
    return rank;
  }

  public void setRank(Integer rank) {
    this.rank = rank;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HeroDto heroDto = (HeroDto) o;
    return Objects.equals(name, heroDto.name) &&
        Objects.equals(description, heroDto.description) &&
        Objects.equals(rank, heroDto.rank);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, rank);
  }


  @Override
  public String toString() {
    return "HeroDto{" +
        "name='" + name + '\'' +
        ", description='" + description + '\'' +
        ", ranks=" + rank +
        '}';
  }
}
