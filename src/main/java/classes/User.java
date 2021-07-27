package classes;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Data
@AllArgsConstructor
@Builder
public class User {

    private String name;
    private String surname;
    private String email;
    private String password;
}
