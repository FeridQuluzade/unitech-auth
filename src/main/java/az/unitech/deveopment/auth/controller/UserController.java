package az.unitech.deveopment.auth.controller;

import az.unitech.deveopment.auth.domain.User;
import az.unitech.deveopment.auth.dto.UserCreateDto;
import az.unitech.deveopment.auth.dto.UserDto;
import az.unitech.deveopment.auth.service.TokenService;
import az.unitech.deveopment.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.net.URI;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final TokenService tokenService;

    @GetMapping("/user/{documentPin}")
    public ResponseEntity<User> getUser(@PathVariable String documentPin) {
        return ResponseEntity.ok().body(userService.getUser(documentPin));
    }

    @PostMapping("/sign-up")
    public ResponseEntity<UserDto> saveUser(@RequestBody @Valid UserCreateDto userCreateDto) {
        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/auth/sign-up").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(userCreateDto));
    }

    @GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        tokenService.refreshToken(request, response);

    }

    @PostMapping("/token/active")
    public void activeToken(HttpServletRequest request, HttpServletResponse response) {
        tokenService.activeToken(request, response);
    }

}