package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.javafaker.Faker;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRequest {
    @JsonProperty("name")
    private String name;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("email")
    private String email;

    @JsonProperty("status")
    private String status;

    public static UserRequest create() {
        return new UserRequest().setName(Faker.instance().name().fullName())
                .setGender("female")
                .setEmail(Faker.instance().internet().emailAddress())
                .setStatus("active");
    }
}
