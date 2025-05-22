package mk.ukim.finki.emt.labs.demo.Service.application;


import mk.ukim.finki.emt.labs.demo.Model.domain.Host;
import mk.ukim.finki.emt.labs.demo.Model.DTO.CreateHostDto;
import mk.ukim.finki.emt.labs.demo.Model.DTO.DisplayHostDto;
import mk.ukim.finki.emt.labs.demo.Model.views.AccommodationsPerHostView;

import java.util.List;
import java.util.Optional;

public interface IHostApplicationService {

    // Fetch all hosts
    List<DisplayHostDto> findAll();

    // Fetch host by ID
    Optional<DisplayHostDto> findById(long id);

    // Delete host by ID
    void deleteById(long id);

    // Save a new host
    Optional<DisplayHostDto> save(CreateHostDto host);

    // Update an existing host
    Optional<DisplayHostDto> update(long id, CreateHostDto host);

    // Fetch all accommodations per host (materialized view for the number of accommodations per host)
    List<AccommodationsPerHostView> findAllAccommodationsPerHost();

    // Fetch accommodations per host by ID
    AccommodationsPerHostView findAccommodationsPerHost(Long id);

    // Refresh materialized view to reflect data changes
    void refreshMaterializedView();
}
