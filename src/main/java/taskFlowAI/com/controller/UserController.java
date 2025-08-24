package taskFlowAI.com.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import taskFlowAI.com.dto.UserRegistrationRequestDto;
import taskFlowAI.com.dto.UserResponseDto;
import taskFlowAI.com.service.UserService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/taskflowai/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> registerUser(@Valid @RequestBody UserRegistrationRequestDto requestDto) {

        log.info("Received request to register user with email: {}", requestDto.getEmail());

        UserResponseDto responseDto = userService.registerUser(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);

    }
}
