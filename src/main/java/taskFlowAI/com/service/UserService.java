package taskFlowAI.com.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.authentication.password.CompromisedPasswordException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import taskFlowAI.com.dto.UserRegistrationRequestDto;
import taskFlowAI.com.dto.UserResponseDto;
import taskFlowAI.com.exception.UserAlreadyExistsException;
import taskFlowAI.com.mapper.UserMapper;
import taskFlowAI.com.model.User;
import taskFlowAI.com.repository.UserRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final CompromisedPasswordChecker compromisedPasswordChecker;

    public UserResponseDto registerUser(UserRegistrationRequestDto requestDto) {

        log.info("Attempting to register user with email: {}", requestDto.getEmail());

        String email = requestDto.getEmail();

        if (userRepository.existsByEmail(email)) {
            log.warn("Registration failed - User already exists with email: {}", email);
            throw new UserAlreadyExistsException("User with email " + email + "is already registered");
        }

        if (compromisedPasswordChecker.check(requestDto.getPassword()).isCompromised()) {
            throw new CompromisedPasswordException("Password has been exposed in data breaches");
        }

        String encodedPassword = passwordEncoder.encode(requestDto.getPassword());
        User user = userMapper.toEntity(requestDto, encodedPassword);
        User savedUser = userRepository.save(user);

        log.info("User registered successfully with ID: {} and email: {}", savedUser.getId(), savedUser.getEmail());

        return userMapper.toResponseDto(savedUser);
    }
}
