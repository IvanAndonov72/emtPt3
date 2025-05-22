package mk.ukim.finki.emt.labs.demo.events;

import lombok.Getter;
import mk.ukim.finki.emt.labs.demo.Model.domain.Host;
import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;

@Getter
public class HostDeletedEvent extends ApplicationEvent {

    private final LocalDateTime when;

    public HostDeletedEvent(Host source) {
        super(source);
        this.when = LocalDateTime.now();
    }
}

