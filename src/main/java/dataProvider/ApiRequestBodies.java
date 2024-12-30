package dataProvider;

import dto.AddUserRequestDto;
import helpers.EmailIncrementHelper;

public class ApiRequestBodies {

    private int emailAddressIncrement = EmailIncrementHelper.readEmailIncrement();
    private AddUserRequestDto userDto;

    private void increaseIncrement() {
        emailAddressIncrement++;
        EmailIncrementHelper.writeEmailIncrement(emailAddressIncrement);
    }


    public AddUserRequestDto getAddUserRequestBody() {
        userDto = AddUserRequestDto.builder()
                .firstName("John")
                .lastName("Doe")
                .email("test+" + emailAddressIncrement + "@email.com")
                .password("Password!2")
                .build();
        increaseIncrement();
        return userDto;
    }
}
