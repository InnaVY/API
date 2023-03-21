package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

 @JsonProperty("id")
 private int id;

 @JsonProperty("name")
 private String name;

 @JsonProperty("gender")
 private String gender;

 @JsonProperty("email")
 private String email;

 @JsonProperty("status")
 private String status;

}
