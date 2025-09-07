package com.yahikko.mark01.controller.users;

import com.yahikko.mark01.dto.users.DtoInUserYahikko;
import com.yahikko.mark01.dto.users.DtoOutUserYahikko;
import com.yahikko.mark01.service.users.UserServiceYahikko;
import com.yahikko.mark01.util.Enums;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Enums.API_PATH_USER)
@Validated
public class UserControllerYahikko {

    private final UserServiceYahikko userServiceYahikko;

    public UserControllerYahikko(UserServiceYahikko serviceYahikko) {
        this.userServiceYahikko = serviceYahikko;
    }

    @PostMapping(Enums.PATH_USER_END_POINT)
    public ResponseEntity<DtoOutUserYahikko> registerUser(@Valid @RequestBody DtoInUserYahikko userYahikko) {
        DtoOutUserYahikko response = userServiceYahikko.createUser(userYahikko);
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping("/retov")
    public ResponseEntity<String> retov(){
        return ResponseEntity.ok("Hola mundo reto V UVEG");
    }

}
