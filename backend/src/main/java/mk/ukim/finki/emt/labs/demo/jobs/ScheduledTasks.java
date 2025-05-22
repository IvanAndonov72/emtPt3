package mk.ukim.finki.emt.labs.demo.jobs;

import mk.ukim.finki.emt.labs.demo.Service.application.IHostApplicationService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    private final IHostApplicationService hostApplicationService;

    public ScheduledTasks(IHostApplicationService hostApplicationService) {
        this.hostApplicationService = hostApplicationService;
    }

    @Scheduled(cron = "0 0 * * * *")  // Every hour
    public void refreshMaterializedView() {
        this.hostApplicationService.refreshMaterializedView();  // Refresh the materialized view for hosts
    }
}
