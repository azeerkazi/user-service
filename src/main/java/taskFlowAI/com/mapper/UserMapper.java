package taskFlowAI.com.mapper;

import org.springframework.stereotype.Component;
import taskFlowAI.com.dto.UserRegistrationRequestDto;
import taskFlowAI.com.dto.UserResponseDto;
import taskFlowAI.com.enums.UserRole;
import taskFlowAI.com.model.User;

@Component
public class UserMapper {

    public User toEntity(UserRegistrationRequestDto requestDto, String encodedPassword) {
        return User.builder()
                .name(requestDto.getName())
                .email(requestDto.getEmail())
                .password(encodedPassword)
                .dob(requestDto.getDob())
                .phoneNumber(requestDto.getPhoneNumber())
                .userRole(UserRole.USER)
                .build();
    }

    public UserResponseDto toResponseDto(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .dob(user.getDob())
                .phoneNumber(user.getPhoneNumber())
                .userRole(user.getUserRole())
                .build();
    }
}
