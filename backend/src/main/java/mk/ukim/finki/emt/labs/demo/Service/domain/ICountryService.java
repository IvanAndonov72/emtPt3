package mk.ukim.finki.emt.labs.demo.Service.domain;

import mk.ukim.finki.emt.labs.demo.model.domain.Country;

import java.util.List;
import java.util.Optional;

public interface ICountryService {
    List<Country> findAll();
    Optional<Country> findById(long id);
    void deleteById(long id);
    Optional<Country> save(Country country);
    Optional<Country> update(long id, Country country);
}
