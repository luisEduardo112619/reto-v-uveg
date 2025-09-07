package com.yahikko.mark01.repository.users;

import com.yahikko.mark01.model.users.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class UserRepositoryYahikko {
    private final JdbcTemplate jdbcTemplate;

    public UserRepositoryYahikko(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User executeSaveUser(User user) {

        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement("INSERT INTO YAHIKKO_MANAGMENT_USERS (first_name, second_name, last_name, second_last_name, email, password, enabled, created_at, updated_at, roles) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
                    , Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getSecondName());
            ps.setString(3, user.getLastName());
            ps.setString(4, user.getSecondLastName());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getPassword());
            ps.setBoolean(7, user.getEnabled());
            ps.setObject(8, user.getCreateAt());
            ps.setObject(9, user.getUpdateAt());
            ps.setString(10, user.getRol());

            return ps;
        });

        return user;
    }
}
