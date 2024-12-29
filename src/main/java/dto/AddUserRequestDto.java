package dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddUserRequestDto {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @JsonIgnore
    private short _id;
    @JsonIgnore
    private String token;

}
