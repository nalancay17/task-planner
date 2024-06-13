package com.nico.taskplanner.dto;

import com.nico.taskplanner.entity.constants.UserTestConstants;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.nico.taskplanner.ValidationsManager.*;
import static com.nico.taskplanner.ValidationsManager.assertConstraintViolationOnAttribute;
import static org.junit.jupiter.api.Assertions.*;

class UserProfileDtoTest {

    private UserProfileDto userProfileDto;

    @BeforeAll
    public static void setUpValidator() {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        setValidator(validator);
    }

    @BeforeEach
    public void setUp() {
        userProfileDto = new UserProfileDto();
        userProfileDto.setId(UserTestConstants.ID_OK);
        userProfileDto.setName(UserTestConstants.NAME_OK);
        userProfileDto.setSurname(UserTestConstants.SURNAME_OK);
        userProfileDto.setEmail(UserTestConstants.EMAIL_OK);
        userProfileDto.setUsername(UserTestConstants.USERNAME_OK);
        userProfileDto.setPassword(UserTestConstants.PASSWORD_OK);
        userProfileDto.setRegistrationDate(UserTestConstants.REGISTRATION_DATE_OK);
        userProfileDto.setEnabled(UserTestConstants.ENABLED_TRUE);
    }

    @Test
    public void userProfileDtoCreationOkTest() {
        assertNoViolations(userProfileDto);
        assertEquals(UserTestConstants.ID_OK, userProfileDto.getId());
        assertEquals(UserTestConstants.NAME_OK, userProfileDto.getName());
        assertEquals(UserTestConstants.SURNAME_OK, userProfileDto.getSurname());
        assertEquals(UserTestConstants.EMAIL_OK, userProfileDto.getEmail());
        assertEquals(UserTestConstants.USERNAME_OK, userProfileDto.getUsername());
        assertEquals(UserTestConstants.PASSWORD_OK, userProfileDto.getPassword());
        assertEquals(UserTestConstants.REGISTRATION_DATE_OK, userProfileDto.getRegistrationDate());
        assertEquals(UserTestConstants.ENABLED_TRUE, userProfileDto.isEnabled());
    }

    @ParameterizedTest
    @ValueSource(longs = {UserTestConstants.ID_POSITIVE, UserTestConstants.ID_ZERO})
    public void userProfileDtoValidIdTest(long id) {
        userProfileDto.setId(id);

        assertNoViolations(userProfileDto);
        assertEquals(id, userProfileDto.getId());
    }

    @Test
    public void userProfileDtoNegativeIdTest() {
        userProfileDto.setId(UserTestConstants.ID_NEGATIVE);

        assertConstraintViolationOnAttribute(userProfileDto, "id", UserTestConstants.ID_POSITIVE_VALIDATION_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {UserTestConstants.NAME_OK, UserTestConstants.NAME_SIZE_EQUALS_MIN, UserTestConstants.NAME_SIZE_EQUALS_MAX})
    public void userProfileDtoValidNameSizeTest(String name) {
        userProfileDto.setName(name);

        assertNoViolations(userProfileDto);
        assertEquals(name, userProfileDto.getName());
    }

    @ParameterizedTest
    @ValueSource(strings = {UserTestConstants.NAME_SIZE_LESS_THAN_MIN, UserTestConstants.NAME_SIZE_MORE_THAN_MAX})
    public void userProfileDtoInvalidNameSizeTest(String name) {
        userProfileDto.setName(name);

        assertConstraintViolationOnAttribute(userProfileDto, "name", UserTestConstants.NAME_SIZE_VALIDATION_MESSAGE);
    }

    @Test
    public void userProfileDtoNullNameTest() {
        userProfileDto.setName(null);

        assertConstraintViolationOnAttribute(userProfileDto, "name", UserTestConstants.NAME_NULL_VALIDATION_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {UserTestConstants.SURNAME_OK, UserTestConstants.SURNAME_SIZE_EQUALS_MIN, UserTestConstants.SURNAME_SIZE_EQUALS_MAX})
    public void useruserProfileDtoValidSurnameSizeTest(String surname) {
        userProfileDto.setSurname(surname);

        assertNoViolations(userProfileDto);
        assertEquals(surname, userProfileDto.getSurname());
    }

    @ParameterizedTest
    @ValueSource(strings = {UserTestConstants.SURNAME_SIZE_LESS_THAN_MIN, UserTestConstants.SURNAME_SIZE_MORE_THAN_MAX})
    public void userProfileDtoInvalidSurnameSizeTest(String surname) {
        userProfileDto.setSurname(surname);

        assertConstraintViolationOnAttribute(userProfileDto, "surname", UserTestConstants.SURNAME_SIZE_VALIDATION_MESSAGE);
    }

    @Test
    public void userProfileDtoNullSurnameTest() {
        userProfileDto.setSurname(null);

        assertConstraintViolationOnAttribute(userProfileDto, "surname", UserTestConstants.SURNAME_NULL_VALIDATION_MESSAGE);
    }

    @Test
    public void userProfileDtoInvalidEmailFormatTest() {
        userProfileDto.setEmail(UserTestConstants.EMAIL_INVALID_FORMAT);

        assertConstraintViolationOnAttribute(userProfileDto, "email", UserTestConstants.EMAIL_EMAIL_VALIDATION_MESSAGE);
    }

    @Test
    public void userProfileDtoNullEmailTest() {
        userProfileDto.setEmail(null);

        assertConstraintViolationOnAttribute(userProfileDto, "email", UserTestConstants.EMAIL_NULL_VALIDATION_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {UserTestConstants.USERNAME_OK, UserTestConstants.USERNAME_SIZE_EQUALS_MIN, UserTestConstants.USERNAME_SIZE_EQUALS_MAX})
    public void userProfileDtoValidUsernameSizeTest(String username) {
        userProfileDto.setUsername(username);

        assertNoViolations(userProfileDto);
        assertEquals(username, userProfileDto.getUsername());
    }

    @ParameterizedTest
    @ValueSource(strings = {UserTestConstants.USERNAME_SIZE_LESS_THAN_MIN, UserTestConstants.USERNAME_SIZE_MORE_THAN_MAX})
    public void userProfileDtoInvalidUsernameSizeTest(String username) {
        userProfileDto.setUsername(username);

        assertConstraintViolationOnAttribute(userProfileDto, "username", UserTestConstants.USERNAME_SIZE_VALIDATION_MESSAGE);
    }

    @Test
    public void userProfileDtoNullUsernameTest() {
        userProfileDto.setUsername(null);

        assertConstraintViolationOnAttribute(userProfileDto, "username", UserTestConstants.USERNAME_NULL_VALIDATION_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {UserTestConstants.PASSWORD_OK, UserTestConstants.PASSWORD_SIZE_EQUALS_MIN, UserTestConstants.PASSWORD_SIZE_EQUALS_MAX})
    public void userProfileDtoValidPasswordSizeTest(String password) {
        userProfileDto.setPassword(password);

        assertNoViolations(userProfileDto);
        assertEquals(password, userProfileDto.getPassword());
    }

    @ParameterizedTest
    @ValueSource(strings = {UserTestConstants.PASSWORD_SIZE_LESS_THAN_MIN, UserTestConstants.PASSWORD_SIZE_MORE_THAN_MAX})
    public void userProfileDtoInvalidPasswordSizeTest(String password) {
        userProfileDto.setPassword(password);

        assertConstraintViolationOnAttribute(userProfileDto, "password", UserTestConstants.PASSWORD_SIZE_VALIDATION_MESSAGE);
    }

    @Test
    public void userProfileDtoNullPasswordTest() {
        userProfileDto.setPassword(null);

        assertConstraintViolationOnAttribute(userProfileDto, "password", UserTestConstants.PASSWORD_NULL_VALIDATION_MESSAGE);
    }

    @Test
    public void userProfileDtoInvalidRegistrationDate() {
        userProfileDto.setRegistrationDate(UserTestConstants.REGISTRATION_DATE_IN_FUTURE);

        assertConstraintViolationOnAttribute(userProfileDto, "registrationDate", UserTestConstants.REGISTRATION_DATE_PAST_OR_PRESENT_VALIDATION_MESSAGE);
    }

    @Test
    public void userProfileDtoNullRegistrationDate() {
        userProfileDto.setRegistrationDate(null);

        assertConstraintViolationOnAttribute(userProfileDto, "registrationDate", UserTestConstants.REGISTRATION_DATE_NULL_VALIDATION_MESSAGE);
    }
}