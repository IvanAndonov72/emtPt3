package mk.ukim.finki.emt.labs.demo.listeners;

import mk.ukim.finki.emt.labs.demo.events.HostChangedEvent;
import mk.ukim.finki.emt.labs.demo.events.HostCreatedEvent;
import mk.ukim.finki.emt.labs.demo.events.HostDeletedEvent;
import mk.ukim.finki.emt.labs.demo.service.application.IHostApplicationService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class HostEventHandlers {

    private final IHostApplicationService hostApplicationService;

    public HostEventHandlers(IHostApplicationService hostApplicationService) {
        this.hostApplicationService = hostApplicationService;
    }

    @EventListener
    public void onHostCreated(HostCreatedEvent event) {
        this.hostApplicationService.refreshMaterializedView();
    }

    @EventListener
    public void onHostDeleted(HostDeletedEvent event) {
        this.hostApplicationService.refreshMaterializedView();
    }

    @EventListener
    public void onHostChanged(HostChangedEvent event) {
        this.hostApplicationService.refreshMaterializedView();
    }
}
