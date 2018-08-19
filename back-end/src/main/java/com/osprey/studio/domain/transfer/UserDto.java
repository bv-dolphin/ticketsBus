package com.osprey.studio.domain.transfer;

import com.osprey.studio.domain.entities.User;
import com.osprey.studio.domain.enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
@Builder
public class UserDto {
    private String email;
    private String password;
    private State state;


    public static UserDto from(User user) {
        return UserDto.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .state(user.getState())
                .build();
    }

    public static List<UserDto> from(List<User> users) {
        return users.stream().map(UserDto::from).collect(Collectors.toList());
    }

}
