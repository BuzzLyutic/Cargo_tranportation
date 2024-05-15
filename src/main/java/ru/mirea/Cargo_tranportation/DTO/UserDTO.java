package ru.mirea.Cargo_tranportation.DTO;


import lombok.Getter;
import lombok.Setter;
import ru.mirea.Cargo_tranportation.model.Role;

@Setter
@Getter
public class UserDTO {
    private String username;
    private String password;
    private String email;
    private String role;

    public UserDTO(String username, String password, String email, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }
}
