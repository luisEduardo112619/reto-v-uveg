package com.yahikko.mark01.service.users;

import com.yahikko.mark01.dto.users.DtoOutUserYahikko;
import com.yahikko.mark01.dto.users.DtoInUserYahikko;
import com.yahikko.mark01.exception.BusinessServiceException;
import com.yahikko.mark01.model.users.User;
import com.yahikko.mark01.repository.users.UserRepositoryYahikko;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;

@Service
@Transactional
public class UserServiceYahikko {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceYahikko.class);

    private final UserRepositoryYahikko userRepositoryYahikko;
    private final PasswordEncoder passwordEncoder;

    public UserServiceYahikko(UserRepositoryYahikko userRepositoryYahikko, PasswordEncoder passwordEncoder){
        this.userRepositoryYahikko = userRepositoryYahikko;
        this.passwordEncoder = passwordEncoder;
    }

    public DtoOutUserYahikko createUser(DtoInUserYahikko dtoInUserYahikko){
        logger.debug("Inicia creacion del usuario: {}", dtoInUserYahikko);

        try {
            logger.debug("Entra al try para crear usuario: {}", dtoInUserYahikko);
            if (dtoInUserYahikko.getFirstName().isBlank() ||
                    dtoInUserYahikko.getSecondName().isBlank() ||
            dtoInUserYahikko.getLastName().isBlank() ||
            dtoInUserYahikko.getSecondLastName().isBlank() ||
            dtoInUserYahikko.getEmail().isBlank() ||
            dtoInUserYahikko.getPassword().isBlank()){
                throw BusinessServiceException.mandatoryParametersMissing();
            }
            User user = new User();

            user.setFirstName(dtoInUserYahikko.getFirstName());
            user.setSecondName(dtoInUserYahikko.getSecondName());
            user.setLastName(dtoInUserYahikko.getLastName());
            user.setSecondLastName(dtoInUserYahikko.getSecondLastName());
            user.setEmail(dtoInUserYahikko.getEmail());
            user.setPassword(passwordEncoder.encode(dtoInUserYahikko.getPassword()));
            user.setEnabled(true);
            user.setCreateAt(LocalDateTime.now());
            user.setUpdateAt(LocalDateTime.now());
            user.setRol("ROLE_USER");

            User savedUser = userRepositoryYahikko.executeSaveUser(user);

            return mapToResponse(savedUser);
        }catch (BusinessServiceException e) {
            logger.error("Error de negocio al crear usuario: {}", e.getMessage());
            throw e;
        }

    }

    private DtoOutUserYahikko mapToResponse(User user){
        DtoOutUserYahikko dtoOutUserYahikko = new DtoOutUserYahikko();
        dtoOutUserYahikko.setFirstName(user.getFirstName());
        dtoOutUserYahikko.setSecondName(user.getSecondName());
        dtoOutUserYahikko.setLastName(user.getLastName());
        dtoOutUserYahikko.setSecondLastName(user.getSecondLastName());
        dtoOutUserYahikko.setEmail(user.getEmail());
        dtoOutUserYahikko.setEnabled(user.getEnabled());
        dtoOutUserYahikko.setCreateAt(user.getCreateAt());
        dtoOutUserYahikko.setRol(user.getRol());

        return dtoOutUserYahikko;
    }
}
