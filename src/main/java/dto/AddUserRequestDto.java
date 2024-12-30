package dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

/**
 * <p>This class represents the request body for creating a user via the API. This DTO is used to serialize the data
 * sent in the POST request to the /users endpoint.</p>
 * <p><i><b>Serialization is the process of converting object state into a format that can be transmitted or stored.<b/></i><p/>
 * <p>When the test sends a request, this DTO is serialized into JSON format.<p/>
 */

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
    @JsonProperty("_id")
    private String userId;
    @JsonIgnore
    private String token;

}
