package com.nico.taskplanner.entity.constants;

import com.nico.taskplanner.entity.AccessPermission;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class UserTestConstants {

    public static final long ID_OK = 1L;
    public static final long ID_POSITIVE = 3L;
    public static final long ID_ZERO = 0L;
    public static final long ID_NEGATIVE = -1L;
    public static final String NAME_OK = "Carlos";
    public static final String NAME_SIZE_EQUALS_MIN = "Li";
    public static final String NAME_SIZE_LESS_THAN_MIN = "A";
    public static final String NAME_SIZE_EQUALS_MAX = "Juan Carlos Alberto José de Santo Javier";
    public static final String NAME_SIZE_MORE_THAN_MAX = "Maximiliano Esteban Daniels Montes Javier";
    public static final String SURNAME_OK = "Fuentes";
    public static final String SURNAME_SIZE_EQUALS_MIN = "Li";
    public static final String SURNAME_SIZE_LESS_THAN_MIN = "M";
    public static final String SURNAME_SIZE_EQUALS_MAX = "Di María Rodriguez Perez Martine Alcaraz";
    public static final String SURNAME_SIZE_MORE_THAN_MAX = "Santos Fernandez Alfaro los Remedios Lina";
    public static final String EMAIL_OK = "cfuentes@example.com";
    public static final String EMAIL_INVALID_FORMAT = "cfuentesexample.com";
    public static final String USERNAME_OK = "cfuentes17";
    public static final String USERNAME_SIZE_EQUALS_MIN = "cf17";
    public static final String USERNAME_SIZE_LESS_THAN_MIN = "cf1";
    public static final String USERNAME_SIZE_EQUALS_MAX = "carlos_fuentes_12345";
    public static final String USERNAME_SIZE_MORE_THAN_MAX = "carlos_fuentes_123456";
    public static final String PASSWORD_OK = "qwertyuiop1234567890qwertyuiop1234567890qwertyuiop1234567890qwertyuiop1234567890";
    public static final String PASSWORD_SIZE_EQUALS_MIN = "This password has sixty characters in total as it is the min";
    public static final String PASSWORD_SIZE_LESS_THAN_MIN = "This password has fifty-nine characters, less than minimum!";
    public static final String PASSWORD_SIZE_EQUALS_MAX = "This password has two thousand fifty five characters in total. It is an example, although in production the password stored here must be" +
            "encrypted by using an algorithm. It has two thousand fifty five characters in total. Fifty five characters in total!!!!";
    public static final String PASSWORD_SIZE_MORE_THAN_MAX = "This password has two thousand fifty six characters in total. This password has two thousand fifty six characters in total. This password has" +
            "two thousand fifty six characters in total. This password has two thousand fifty six characters in total aaaaaaaaaa";
    public static final Set<AccessPermission> ACCESS_PERMISSIONS_OK = new HashSet<>();
    public static final Timestamp REGISTRATION_DATE_OK = new Timestamp(1656662400000L);
    public static final Timestamp REGISTRATION_DATE_IN_FUTURE = new Timestamp(10951296000000L);
    public static boolean ENABLED_TRUE = true;

    public static final String ID_POSITIVE_VALIDATION_MESSAGE = "El id del usuario no puede ser negativo";
    public static final String NAME_NULL_VALIDATION_MESSAGE = "El nombre del usuario no puede ser null";
    public static final String NAME_SIZE_VALIDATION_MESSAGE = "El nombre del usuario debe tener entre 2 y 40 caracteres";
    public static final String SURNAME_NULL_VALIDATION_MESSAGE = "El apellido del usuario no puede ser null";
    public static final String SURNAME_SIZE_VALIDATION_MESSAGE = "El apellido del usuario debe tener entre 2 y 40 caracteres";
    public static final String EMAIL_NULL_VALIDATION_MESSAGE = "El email del usuario no puede ser null";
    public static final String EMAIL_EMAIL_VALIDATION_MESSAGE = "El email del usuario tiene un formato inválido";
    public static final String USERNAME_NULL_VALIDATION_MESSAGE = "El username del usuario no puede ser null";
    public static final String USERNAME_SIZE_VALIDATION_MESSAGE = "El username del usuario debe tener entre 4 y 20 caracteres";
    public static final String PASSWORD_NULL_VALIDATION_MESSAGE = "La contraseña del usuario no puede ser null";
    public static final String PASSWORD_SIZE_VALIDATION_MESSAGE = "La contraseña del usuario debe tener entre 60 y 255 caracteres";
    public static final String ACCESS_PERMISSIONS_NULL_VALIDATION_MESSAGE = "El conjunto de permisos del usuario no puede ser null";
    public static final String REGISTRATION_DATE_NULL_VALIDATION_MESSAGE = "La fecha de registro del usuario no puede ser null";
    public static final String REGISTRATION_DATE_PAST_OR_PRESENT_VALIDATION_MESSAGE = "La fecha de registro del usuario debe ser pasada o actual";

}
