package com.nico.taskplanner.service.constants;

import com.nico.taskplanner.dto.UserProfileDto;
import com.nico.taskplanner.dto.UserRegistrationDto;
import com.nico.taskplanner.entity.User;

import java.sql.Timestamp;

public class AuthenticationServiceImplTestConstants {

    public static final int USER_ID = 1;

    public static final String USER_NAME = "Carlos";

    public static final String USER_SURNAME = "Fuentes";

    public static final String USER_EMAIL = "cfuentes@example.com";

    public static final String USER_USERNAME = "cfuentes77";

    public static final String USER_PASSWORD = "qwertyuiop1234567890qwertyuiop1234567890qwertyuiop1234567890qwertyuiop1234567890";

    public static final boolean USER_ENABLED_FALSE = false;

    public static UserRegistrationDto createUserRegistrationDtoFromConstants() {
        return new UserRegistrationDto(AuthenticationServiceImplTestConstants.USER_NAME,
                AuthenticationServiceImplTestConstants.USER_SURNAME, AuthenticationServiceImplTestConstants.USER_EMAIL,
                AuthenticationServiceImplTestConstants.USER_USERNAME, AuthenticationServiceImplTestConstants.USER_PASSWORD);
    }

    public static UserProfileDto createUserProfileDtoFromConstants() {
        return new UserProfileDto(AuthenticationServiceImplTestConstants.USER_ID, AuthenticationServiceImplTestConstants.USER_NAME,
                AuthenticationServiceImplTestConstants.USER_SURNAME, AuthenticationServiceImplTestConstants.USER_EMAIL,
                AuthenticationServiceImplTestConstants.USER_USERNAME, AuthenticationServiceImplTestConstants.USER_PASSWORD,
                getCurrentTimeStamp(), AuthenticationServiceImplTestConstants.USER_ENABLED_FALSE);
    }

    public static User createUserFromConstants() {
        User user = new User();
        user.setId(AuthenticationServiceImplTestConstants.USER_ID);
        user.setName(AuthenticationServiceImplTestConstants.USER_NAME);
        user.setSurname(AuthenticationServiceImplTestConstants.USER_SURNAME);
        user.setEmail(AuthenticationServiceImplTestConstants.USER_EMAIL);
        user.setUsername(AuthenticationServiceImplTestConstants.USER_USERNAME);
        user.setPassword(AuthenticationServiceImplTestConstants.USER_PASSWORD);
        return user;
    }

    private static Timestamp getCurrentTimeStamp() {
        return new Timestamp(System.currentTimeMillis());
    }

}
