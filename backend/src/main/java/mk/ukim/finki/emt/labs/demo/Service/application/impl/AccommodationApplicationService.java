package mk.ukim.finki.emt.labs.demo.Service.application.impl;

import mk.ukim.finki.emt.labs.demo.Model.domain.Accommodation;
import mk.ukim.finki.emt.labs.demo.Model.DTO.CreateAccommodationDto;
import mk.ukim.finki.emt.labs.demo.Model.DTO.DisplayAccommodationDto;
import mk.ukim.finki.emt.labs.demo.Service.application.IAccommodationApplicationService;
import mk.ukim.finki.emt.labs.demo.Service.domain.IAccommodationService;
import mk.ukim.finki.emt.labs.demo.Service.domain.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationApplicationService implements IAccommodationApplicationService {

    private final IAccommodationService accommodationService;
    private final IUserService userService;

    public AccommodationApplicationService(IAccommodationService accommodationService, IUserService userService) {
        this.accommodationService = accommodationService;
        this.userService = userService;
    }

    @Override
    public List<DisplayAccommodationDto> findAll() {
        return accommodationService.findAll().stream()
                .map(DisplayAccommodationDto::from)
                .toList();
    }

    @Override
    public Optional<DisplayAccommodationDto> findById(long id) {
        return accommodationService.findById(id).map(DisplayAccommodationDto::from);
    }

    @Override
    public Optional<DisplayAccommodationDto> save(CreateAccommodationDto accommodation) {
        Accommodation accommodation1 = accommodation.toAccommodation();
        return accommodationService.save(accommodation1).map(DisplayAccommodationDto::from);
    }

    @Override
    public Optional<DisplayAccommodationDto> update(long id, CreateAccommodationDto accommodation) {
        Accommodation accommodation1 = accommodation.toAccommodation();
        return accommodationService.update(id, accommodation1).map(DisplayAccommodationDto::from);
    }

    @Override
    public void deleteById(long id) {
        accommodationService.deleteById(id);
    }

    // Temporary Reservation List Management

    @Override
    public void addAccommodationToTempReservation(Long id, String token) {
        accommodationService.addAccommodationToTempReservation(id, token);
    }

    @Override
    public void removeAccommodationFromTempReservation(Long id, String token) {
        accommodationService.removeAccommodationFromTempReservation(id, token);
    }

    @Override
    public List<DisplayAccommodationDto> viewTempReservationList(String token) {
        return accommodationService.viewTempReservationList(token).stream()
                .map(DisplayAccommodationDto::from)
                .toList();
    }

    @Override
    public boolean confirmAllReservations(String token) {
        return accommodationService.confirmAllReservations(token);
    }

    @Override
    public boolean confirmReservation(Long id, String token) {
        return accommodationService.confirmReservation(id, token);
    }

    @Override
    public void cancelReservation(Long id, String token) {
        accommodationService.cancelReservation(id, token);
    }
}
