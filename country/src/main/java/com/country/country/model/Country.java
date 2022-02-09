package com.country.country.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties
public class Country {
   private Name name;
   private List<String> tdl;
   private String cca2;
   private String ccn3;
   private String cca3;
   private String cioc;
   private Boolean independent;
   private String status;
   private Boolean unMember;
   private Currencies currencies;
   private Idd idd;
   private List<String> capital;
   private List<String> altSpellings;
   private String region;
   private String subregion;
   private List<Double>latlng;
   private Boolean landlocked;
   private List<String>borders;
}
