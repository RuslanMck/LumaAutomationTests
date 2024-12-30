package steps.api;

import dto.AddUserRequestDto;
import dto.AddUserResponseDto;
import dto.AddUserResponseWrapperDto;
import service.UserService;

public class AddUserSteps {
    private final UserService userService = new UserService();

    public AddUserResponseWrapperDto createUser(AddUserRequestDto userRequestDto){
        AddUserRequestDto requestDto = AddUserRequestDto.builder()
                .firstName(userRequestDto.getFirstName())
                .lastName(userRequestDto.getLastName())
                .email(userRequestDto.getEmail())
                .password(userRequestDto.getPassword())
                .build();

                return userService.addUser(requestDto);
    }
}
