package mk.ukim.finki.emt.labs.demo.Service.application;

import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.emt.labs.demo.Model.DTO.CreateUserDto;
import mk.ukim.finki.emt.labs.demo.Model.DTO.DisplayUserDto;
import mk.ukim.finki.emt.labs.demo.Model.DTO.LoginResponseDto;
import mk.ukim.finki.emt.labs.demo.Model.DTO.LoginUserDto;
import mk.ukim.finki.emt.labs.demo.Model.projections.UserProjection;

import java.util.List;
import java.util.Optional;

public interface IUserApplicationService {
    Optional<DisplayUserDto> register(CreateUserDto createUserDto);
    Optional<LoginResponseDto> login(LoginUserDto loginUserDto);
    Optional<DisplayUserDto> findByUsername(String username);
    List<UserProjection> getAllUserNames();
}
