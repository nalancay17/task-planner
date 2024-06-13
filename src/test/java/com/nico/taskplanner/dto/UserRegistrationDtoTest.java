package com.nico.taskplanner.dto;

import com.nico.taskplanner.entity.constants.UserTestConstants;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static com.nico.taskplanner.ValidationsManager.*;

class UserRegistrationDtoTest {

    private UserRegistrationDto userRegistrationDto;

    @BeforeAll
    public static void setUpValidator() {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        setValidator(validator);
    }

    @BeforeEach
    public void setUp() {
        userRegistrationDto = new UserRegistrationDto();
        userRegistrationDto.setName(UserTestConstants.NAME_OK);
        userRegistrationDto.setSurname(UserTestConstants.SURNAME_OK);
        userRegistrationDto.setEmail(UserTestConstants.EMAIL_OK);
        userRegistrationDto.setUsername(UserTestConstants.USERNAME_OK);
        userRegistrationDto.setPassword(UserTestConstants.PASSWORD_OK);
    }

    @Test
    public void userRegistrationDtoCreationOkTest() {
        assertNoViolations(userRegistrationDto);
        assertEquals(UserTestConstants.NAME_OK, userRegistrationDto.getName());
        assertEquals(UserTestConstants.SURNAME_OK, userRegistrationDto.getSurname());
        assertEquals(UserTestConstants.EMAIL_OK, userRegistrationDto.getEmail());
        assertEquals(UserTestConstants.USERNAME_OK, userRegistrationDto.getUsername());
        assertEquals(UserTestConstants.PASSWORD_OK, userRegistrationDto.getPassword());
    }

    @ParameterizedTest
    @ValueSource(strings = {UserTestConstants.NAME_OK, UserTestConstants.NAME_SIZE_EQUALS_MIN, UserTestConstants.NAME_SIZE_EQUALS_MAX})
    public void userRegistrationDtoValidNameSizeTest(String name) {
        userRegistrationDto.setName(name);

        assertNoViolations(userRegistrationDto);
        assertEquals(name, userRegistrationDto.getName());
    }

    @ParameterizedTest
    @ValueSource(strings = {UserTestConstants.NAME_SIZE_LESS_THAN_MIN, UserTestConstants.NAME_SIZE_MORE_THAN_MAX})
    public void userRegistrationDtoInvalidNameSizeTest(String name) {
        userRegistrationDto.setName(name);

        assertConstraintViolationOnAttribute(userRegistrationDto, "name", UserTestConstants.NAME_SIZE_VALIDATION_MESSAGE);
    }

    @Test
    public void userRegistrationDtoNullNameTest() {
        userRegistrationDto.setName(null);

        assertConstraintViolationOnAttribute(userRegistrationDto, "name", UserTestConstants.NAME_NULL_VALIDATION_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {UserTestConstants.SURNAME_OK, UserTestConstants.SURNAME_SIZE_EQUALS_MIN, UserTestConstants.SURNAME_SIZE_EQUALS_MAX})
    public void userRegistrationDtoValidSurnameSizeTest(String surname) {
        userRegistrationDto.setSurname(surname);

        assertNoViolations(userRegistrationDto);
        assertEquals(surname, userRegistrationDto.getSurname());
    }

    @ParameterizedTest
    @ValueSource(strings = {UserTestConstants.SURNAME_SIZE_LESS_THAN_MIN, UserTestConstants.SURNAME_SIZE_MORE_THAN_MAX})
    public void userRegistrationDtoInvalidSurnameSizeTest(String surname) {
        userRegistrationDto.setSurname(surname);

        assertConstraintViolationOnAttribute(userRegistrationDto, "surname", UserTestConstants.SURNAME_SIZE_VALIDATION_MESSAGE);
    }

    @Test
    public void userRegistrationDtoNullSurnameTest() {
        userRegistrationDto.setSurname(null);

        assertConstraintViolationOnAttribute(userRegistrationDto, "surname", UserTestConstants.SURNAME_NULL_VALIDATION_MESSAGE);
    }

    @Test
    public void userRegistrationDtoInvalidEmailFormatTest() {
        userRegistrationDto.setEmail(UserTestConstants.EMAIL_INVALID_FORMAT);

        assertConstraintViolationOnAttribute(userRegistrationDto, "email", UserTestConstants.EMAIL_EMAIL_VALIDATION_MESSAGE);
    }

    @Test
    public void userRegistrationDtoNullEmailTest() {
        userRegistrationDto.setEmail(null);

        assertConstraintViolationOnAttribute(userRegistrationDto, "email", UserTestConstants.EMAIL_NULL_VALIDATION_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {UserTestConstants.USERNAME_OK, UserTestConstants.USERNAME_SIZE_EQUALS_MIN, UserTestConstants.USERNAME_SIZE_EQUALS_MAX})
    public void userRegistrationDtoValidUsernameSizeTest(String username) {
        userRegistrationDto.setUsername(username);

        assertNoViolations(userRegistrationDto);
        assertEquals(username, userRegistrationDto.getUsername());
    }

    @ParameterizedTest
    @ValueSource(strings = {UserTestConstants.USERNAME_SIZE_LESS_THAN_MIN, UserTestConstants.USERNAME_SIZE_MORE_THAN_MAX})
    public void userRegistrationDtoInvalidUsernameSizeTest(String username) {
        userRegistrationDto.setUsername(username);

        assertConstraintViolationOnAttribute(userRegistrationDto, "username", UserTestConstants.USERNAME_SIZE_VALIDATION_MESSAGE);
    }

    @Test
    public void userRegistrationDtoNullUsernameTest() {
        userRegistrationDto.setUsername(null);

        assertConstraintViolationOnAttribute(userRegistrationDto, "username", UserTestConstants.USERNAME_NULL_VALIDATION_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {UserTestConstants.PASSWORD_OK, UserTestConstants.PASSWORD_SIZE_EQUALS_MIN, UserTestConstants.PASSWORD_SIZE_EQUALS_MAX})
    public void userRegistrationDtoValidPasswordSizeTest(String password) {
        userRegistrationDto.setPassword(password);

        assertNoViolations(userRegistrationDto);
        assertEquals(password, userRegistrationDto.getPassword());
    }

    @ParameterizedTest
    @ValueSource(strings = {UserTestConstants.PASSWORD_SIZE_LESS_THAN_MIN, UserTestConstants.PASSWORD_SIZE_MORE_THAN_MAX})
    public void userRegistrationDtoInvalidPasswordSizeTest(String password) {
        userRegistrationDto.setPassword(password);

        assertConstraintViolationOnAttribute(userRegistrationDto, "password", UserTestConstants.PASSWORD_SIZE_VALIDATION_MESSAGE);
    }

    @Test
    public void userRegistrationDtoNullPasswordTest() {
        userRegistrationDto.setPassword(null);

        assertConstraintViolationOnAttribute(userRegistrationDto, "password", UserTestConstants.PASSWORD_NULL_VALIDATION_MESSAGE);
    }

}