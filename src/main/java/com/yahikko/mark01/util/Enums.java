package com.yahikko.mark01.util;

public class Enums {
    public static final String CONTENT_TYPE = "application/json";
    public static final String API_PATH_USER = "business-users/v0";
    public static final String PATH_USER_END_POINT = "/users";
    public static final String YAHIKKO_USERS = "YAHIKKO_MANAGMENT_USERS";
    public static final String MANDATORY_PARAMETERS_MISSING = "El parametro es obligatorio";
    public static final String LENGTH_NOT_ALLOWED = "El parametro debe tener entre 2 y 50 caracteres";
    public static final String FORMAT_NOT_ALLOWED = "El formato no es válido";
    public static final String BAD_FORMAT_PASSWORD = "La contraseña debe tener al menos 8 caracteres";
    public static final String PASSWORD_REGEX = "^(?=.*[A-Za-z])(?=.*\\d).{8,}$";
    public static final String PASSWORD_NOT_ALLOWED = "La contraseña debe contener al menos una mayúscula, una minúscula, un número y un carácter especial";
    public static final String JSON_WEB_TOKEN_TYPE_BEARER = "Bearer";
    public static final String SQL_SAVE_USER = "INSERT INTO users (first_name, second_name, last_name, second_last_name, email, password, enabled, created_at, updated_at, roles) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
}
