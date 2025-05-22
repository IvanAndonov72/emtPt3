package mk.ukim.finki.emt.labs.demo.Service.application.impl;

import mk.ukim.finki.emt.labs.demo.Model.domain.Host;
import mk.ukim.finki.emt.labs.demo.Model.DTO.CreateHostDto;
import mk.ukim.finki.emt.labs.demo.Model.DTO.DisplayHostDto;
import mk.ukim.finki.emt.labs.demo.Model.views.AccommodationsPerHostView;
import mk.ukim.finki.emt.labs.demo.Service.application.IHostApplicationService;
import mk.ukim.finki.emt.labs.demo.Service.domain.IHostService;
import mk.ukim.finki.emt.labs.demo.Service.domain.IAccommodationService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostApplicationService implements IHostApplicationService {

    private final IHostService hostService;
    private final IAccommodationService accommodationService;
    private final ApplicationEventPublisher applicationEventPublisher;

    public HostApplicationService(IHostService hostService, IAccommodationService accommodationService, ApplicationEventPublisher applicationEventPublisher) {
        this.hostService = hostService;
        this.accommodationService = accommodationService;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public List<DisplayHostDto> findAll() {
        return hostService.findAll().stream()
                .map(DisplayHostDto::from)
                .toList();
    }

    @Override
    public Optional<DisplayHostDto> findById(long id) {
        return hostService.findById(id).map(DisplayHostDto::from);
    }

    @Override
    public void deleteById(long id) {
        Host host = hostService.findById(id).orElseThrow();
        hostService.deleteById(id);

        // You can publish an event for deletion if needed
        // this.applicationEventPublisher.publishEvent(new HostDeletedEvent(host));
    }

    @Override
    public Optional<DisplayHostDto> save(CreateHostDto hostDto) {
        Host host = hostDto.toHost();

        // You can publish an event for creation if needed
        // this.applicationEventPublisher.publishEvent(new HostCreatedEvent(host));

        return hostService.save(host).map(DisplayHostDto::from);
    }

    @Override
    public Optional<DisplayHostDto> update(long id, CreateHostDto hostDto) {
        Host host = hostDto.toHost();
        return hostService.update(id, host).map(DisplayHostDto::from);
    }

    // Fetch all accommodations per host (materialized view for the number of accommodations per host)
    @Override
    public List<AccommodationsPerHostView> findAllAccommodationsPerHost() {
        return accommodationService.findAllAccommodationsPerHost();
    }

    // Fetch accommodations per host by ID
    @Override
    public AccommodationsPerHostView findAccommodationsPerHost(Long id) {
        return accommodationService.findAccommodationsPerHost(id);
    }

    // Refresh materialized view to reflect data changes
    @Override
    public void refreshMaterializedView() {
        accommodationService.refreshMaterializedView();
    }
}
