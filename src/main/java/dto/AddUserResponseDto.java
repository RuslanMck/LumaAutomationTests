package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * <code></code> <p></p>
 * <p>Represents the structure of the <code>"user"</code> object in the API's response and used to validate the response
 * data against the expected values.</p>
 * <p>It maps the fields returned by the API for the created user. When the response is received, this DTO maps
 * the <code>"user"</code> object from the JSON response to Java fields.</p>
 *
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddUserResponseDto {

    private String firstName;
    private String lastName;
    private String email;

    /**
     * The API request uses <code>"_id"</code>as a name for the user id value. We use this code to map
     * the <code>"_id"</code> value to the <code>"userId"</code> variable
     */
    @JsonProperty("_id")
    private String userId;
}
