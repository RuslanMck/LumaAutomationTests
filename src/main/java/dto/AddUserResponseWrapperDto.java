package dto;

import lombok.Data;

/**
 * Represents the full response body of the <b>"Add User"<b/> API, including both the <code>user</code> object and
 * the <code>token</code>.
 * Acts as a wrapper for <code>AddUserResponseDto</code>.
 * <p>This class is used to parse the response of the <b>"add user"</b> request correctly.</p>
 *
 * <p>The response contains two parts:</p>
 * <ul>
 *   <li>A <code>user</code> object, which includes user details such as <code>firstName</code>,
 *   <code>lastName</code>, <code>email</code>, and <code>_id</code>.</li>
 *   <li>A <code>token</code> field, which is separate from the <code>user</code> object.</li>
 * </ul>
 *
 * <p>Without this wrapper class, using only <code>AddUserResponseDto</code> would lead to a mismatch because
 * <code>AddUserResponseDto</code> expects a flat structure, but the actual response contains nested data:</p>
 *
 * <h3>Actual response structure:</h3>
 * <pre>
 * {
 *   "user": {
 *     "_id": "value",
 *     "firstName": "value",
 *     "lastName": "value",
 *     "email": "value",
 *     "__v": 1
 *   },
 *   "token": "value"
 * }
 * </pre>
 *
 * <h3>AddUserResponseDto structure:</h3>
 * <pre>
 * {
 *   "firstName": "value",
 *   "lastName": "value",
 *   "email": "value"
 * }
 * </pre>
 *
 * <p>By introducing <code>AddUserResponseWrapperDto</code>, we can correctly map the response structure
 * to separate the <code>user</code> object and the <code>token</code> field.</p>
 */

@Data
public class AddUserResponseWrapperDto {

    private AddUserResponseDto user;
    private String token;

}
