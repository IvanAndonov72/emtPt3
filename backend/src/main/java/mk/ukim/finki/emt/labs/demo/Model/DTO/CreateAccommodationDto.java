package mk.ukim.finki.emt.labs.demo.Model.DTO;

import mk.ukim.finki.emt.labs.demo.Model.domain.Accommodation;
import mk.ukim.finki.emt.labs.demo.Model.domain.Host;
import mk.ukim.finki.emt.labs.demo.Model.enums.Category;

import java.util.List;

public record CreateAccommodationDto(
        String name,
        Category category,
        Long hostId,
        int numRooms
) {
    public Accommodation toAccommodation(Host host) {
        return new Accommodation(name, category, host, numRooms);
    }

    public static CreateAccommodationDto from(Accommodation accommodation) {
        return new CreateAccommodationDto(
                accommodation.getName(),
                accommodation.getCategory(),
                accommodation.getHost().getId(),
                accommodation.getNumRooms()
        );
    }

    public static List<CreateAccommodationDto> from(List<Accommodation> accommodations) {
        return accommodations.stream()
                .map(CreateAccommodationDto::from)
                .toList();
    }
}
