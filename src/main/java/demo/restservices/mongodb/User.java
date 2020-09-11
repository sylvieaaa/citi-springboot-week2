package demo.restservices.mongodb;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public @Data class User {
    private String password;
    private String name;
    private String emailAddress;
    @Id
    private String userId;


    public User(String password, String name, String emailAddress) {
        this.password = password;
        this.name = name;
        this.emailAddress = emailAddress;
    }
}
