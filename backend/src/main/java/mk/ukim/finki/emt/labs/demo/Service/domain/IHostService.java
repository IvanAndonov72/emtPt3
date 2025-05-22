package mk.ukim.finki.emt.labs.demo.Service.domain;

import mk.ukim.finki.emt.labs.demo.Model.domain.Host;

import java.util.List;
import java.util.Optional;

public interface IHostService {
    List<Host> findAll();
    Optional<Host> findById(long id);
    void deleteById(long id);
    Optional<Host> save(Host host);
    Optional<Host> update(long id, Host host);
}
