package mk.ukim.finki.emt.labs.demo.Service.domain;

import mk.ukim.finki.emt.labs.demo.Model.domain.Accommodation;

import java.util.List;
import java.util.Optional;

public interface IAccommodationService {
    List<Accommodation> findAll();
    Optional<Accommodation> findById(long id);
    void deleteById(long id);
    Optional<Accommodation> save(Accommodation accommodation);
    Optional<Accommodation> update(long id, Accommodation accommodation);

    void addAccommodationToTempReservation(Long id, String token);
    void removeAccommodationFromTempReservation(Long id, String token);
    List<Accommodation> viewTempReservationList(String token);

    boolean confirmAllReservations(String token);
    boolean confirmReservation(Long id, String token);
    void cancelReservation(Long id, String token);
}
