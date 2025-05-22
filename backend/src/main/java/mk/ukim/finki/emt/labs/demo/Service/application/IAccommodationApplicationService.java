package mk.ukim.finki.emt.labs.demo.Service.application;

import mk.ukim.finki.emt.labs.demo.Model.DTO.CreateAccommodationDto;
import mk.ukim.finki.emt.labs.demo.Model.DTO.DisplayAccommodationDto;

import java.util.List;
import java.util.Optional;

public interface IAccommodationApplicationService {
    // Find all accommodations
    List<DisplayAccommodationDto> findAll();

    // Find a specific accommodation by ID
    Optional<DisplayAccommodationDto> findById(long id);

    // Create a new accommodation
    Optional<DisplayAccommodationDto> save(CreateAccommodationDto accommodation);

    // Update an existing accommodation
    Optional<DisplayAccommodationDto> update(long id, CreateAccommodationDto accommodation);

    // Delete an accommodation by ID
    void deleteById(long id);

    // Add accommodation to temporary reservation list
    void addAccommodationToTempReservation(Long id, String token);

    // Remove accommodation from temporary reservation list
    void removeAccommodationFromTempReservation(Long id, String token);

    // View temporary reservation list
    List<DisplayAccommodationDto> viewTempReservationList(String token);

    // Confirm reservation for all items in the temporary list
    boolean confirmAllReservations(String token);

    // Confirm reservation for a single accommodation
    boolean confirmReservation(Long id, String token);

    // Cancel a reservation
    void cancelReservation(Long id, String token);
}
