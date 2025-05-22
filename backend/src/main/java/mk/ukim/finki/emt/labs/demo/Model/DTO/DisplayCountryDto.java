package mk.ukim.finki.emt.labs.demo.Model.DTO;


import mk.ukim.finki.emt.labs.demo.Model.domain.Country;
import mk.ukim.finki.emt.labs.demo.Model.DTO.CreateCountryDto;

import java.util.List;

public record DisplayCountryDto (Long id, String name, String continent){
    public Country toCountry(){
        return new Country(name,continent);
    }
    public static DisplayCountryDto from(Country country){
        return new DisplayCountryDto(country.getId(),country.getName(),country.getContinent());
    }
    public static List<DisplayCountryDto> from(List<Country> countryList){
        return countryList.stream()
                .map(c->new DisplayCountryDto(c.getId(),c.getName(),c.getContinent()))
                .toList();
    }
}

