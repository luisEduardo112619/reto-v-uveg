package com.yahikko.mark01.model.users;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

import static com.yahikko.mark01.util.Enums.*;



@NoArgsConstructor
@AllArgsConstructor
@Table(YAHIKKO_USERS)
public class User {
    @Id
    private Long id;

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
    @Size(min = 2, max = 50, message = FORMAT_NOT_ALLOWED)
    private String email;

    @NotBlank(message = MANDATORY_PARAMETERS_MISSING)
    @Size(min = 8, message = BAD_FORMAT_PASSWORD)
    @Pattern(regexp = PASSWORD_REGEX,
            message = PASSWORD_NOT_ALLOWED)
    private String password;

    private Boolean isEnabled;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    private String rol;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
