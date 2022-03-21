package az.unitech.deveopment.auth.service;

import az.unitech.deveopment.auth.domain.User;
import az.unitech.deveopment.auth.dto.UserCreateDto;
import az.unitech.deveopment.auth.mapper.UserMapper;
import az.unitech.deveopment.auth.dto.UserDto;
import az.unitech.deveopment.auth.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String documentPin) throws UsernameNotFoundException {
        User user = userRepository.findByDocumentPin(documentPin).orElseThrow(() ->
                new RuntimeException(documentPin + "username not found in the DB"));
        if (user == null) {
            log.info("User not found in the DB");
            throw new UsernameNotFoundException("User not found in the DB");
        } else {
            log.info("User found in the DB: {}", documentPin);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        return new org.springframework.security.core.userdetails
                .User(user.getDocumentPin(), user.getPassword(), authorities);
    }


    public UserDto saveUser(UserCreateDto userDto) {
        if (userRepository.findByDocumentPin(userDto.getDocumentPin()).isPresent()) {
            throw new RuntimeException(userDto.getDocumentPin() + " user is existed in to the DB");
        }
        User newUser = userMapper.toUser(userDto);
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));

        return userMapper.toUserDto(userRepository.save(newUser));
    }

    public User getUser(String documentPin) {
        return userRepository.findByDocumentPin(documentPin).orElseThrow(() ->
                new RuntimeException(documentPin + "username not found in the DB"));
    }

}