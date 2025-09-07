package com.yahikko.mark01.dto.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import static com.yahikko.mark01.util.Enums.*;

public class DtoInUserYahikko {
    @NotBlank(message = MANDATORY_PARAMETERS_MISSING)
    @Size(min = 2, max = 50, message = LENGTH_NOT_ALLOWED)
    private String firstName;

    private String secondName;

    @NotBlank(message = MANDATORY_PARAMETERS_MISSING)
    @Size(min = 2, max = 50, message = LENGTH_NOT_ALLOWED)
    private String lastName;

    @NotBlank(message = MANDATORY_PARAMETERS_MISSING)
    @Size(min = 2, max = 50, message = LENGTH_NOT_ALLOWED)
    private String secondLastName;

    @NotBlank(message = MANDATORY_PARAMETERS_MISSING)
    @Email
    private String email;

    @NotBlank(message = MANDATORY_PARAMETERS_MISSING)
    @Size(min = 8)
    @Pattern(regexp = PASSWORD_REGEX)
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
