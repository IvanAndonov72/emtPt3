package mk.ukim.finki.emt.labs.demo.Service.application;

import mk.ukim.finki.emt.labs.demo.Model.DTO.CreateCountryDto;
import mk.ukim.finki.emt.labs.demo.Model.DTO.DisplayCountryDto;
import mk.ukim.finki.emt.labs.demo.Model.views.HostsPerCountryView;

import java.util.List;
import java.util.Optional;

public interface ICountryApplicationService {
    List<DisplayCountryDto> findAll();
    Optional<DisplayCountryDto> findById(long id);
    void deleteById(long id);
    Optional<DisplayCountryDto> save(CreateCountryDto country);
    Optional<DisplayCountryDto> update(long id, CreateCountryDto country);

    List<HostsPerCountryView> findAllHostsPerCountry();  // ✅ updated
    HostsPerCountryView findHostsPerCountry(Long id);    // ✅ updated
    void refreshMaterializedView();
}
