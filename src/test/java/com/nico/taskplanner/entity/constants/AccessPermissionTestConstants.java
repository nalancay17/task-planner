package com.nico.taskplanner.entity.constants;

import com.nico.taskplanner.entity.User;

import java.util.HashSet;
import java.util.Set;

public class AccessPermissionTestConstants {

    public static final String NAME_OK = "User";
    public static final String NAME_SIZE_EQUALS_MIN = "ADM";
    public static final String NAME_SIZE_LESS_THAN_MIN = "ID";
    public static final String NAME_SIZE_EQUALS_MAX = "Administrador de proyectos ARG";
    public static final String NAME_SIZE_MORE_THAN_MAX = "Esta cadena tiene 31 caracteres";

    public static final Set<User> USERS_OK = new HashSet<>();

    public static final String NAME_NULL_VALIDATION_MESSAGE = "El nombre del permiso de acceso no puede ser null";
    public static final String NAME_SIZE_VALIDATION_MESSAGE = "El nombre del permiso de acceso debe tener entre 3 y 30 caracteres";
    public static final String USERS_NULL_VALIDATION_MESSAGE = "El conjunto de usuarios del permiso de acceso no puede ser null";

}
