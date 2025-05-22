package mk.ukim.finki.emt.labs.demo.Service.domain;

import mk.ukim.finki.emt.labs.demo.Model.domain.UserEntity;
import mk.ukim.finki.emt.labs.demo.Model.enums.UserRole;
import mk.ukim.finki.emt.labs.demo.Model.projections.UserProjection;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {

    UserEntity register(String username, String password, String repeatPassword, String name, UserRole role);

    UserEntity login(String username, String password);

    UserEntity getAuthenticatedUser(String token);

    UserEntity findByUsername(String username);

    List<UserProjection> getAllUserNames();
}
