package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddUserResponseDto {

    private String firstName;
    private String lastName;
    private String email;

    /**
     * The API request uses "_id" as a name for the user id value. We use this code to map the "_id" value to the
     * userId variable
     */
    @JsonProperty("_id")
    private String userId;
}
