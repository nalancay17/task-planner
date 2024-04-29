package com.nico.taskplanner.entity;

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

class UserTest {

    private User user;

    @BeforeAll
    public static void setUpValidator() {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        setValidator(validator);
    }

    @BeforeEach
    public void setUp() {
        user = new User();
        user.setId(UserTestConstants.ID_OK);
        user.setName(UserTestConstants.NAME_OK);
        user.setSurname(UserTestConstants.SURNAME_OK);
        user.setEmail(UserTestConstants.EMAIL_OK);
        user.setUsername(UserTestConstants.USERNAME_OK);
        user.setPassword(UserTestConstants.PASSWORD_OK);
        user.setAccessPermissions(UserTestConstants.ACCESS_PERMISSIONS_OK);
        user.setRegistrationDate(UserTestConstants.REGISTRATION_DATE_OK);
        user.setEnabled(UserTestConstants.ENABLED_TRUE);
    }

    @Test
    public void userCreationOkTest() {
        assertNoViolations(user);
        assertEquals(UserTestConstants.ID_OK, user.getId());
        assertEquals(UserTestConstants.NAME_OK, user.getName());
        assertEquals(UserTestConstants.SURNAME_OK, user.getSurname());
        assertEquals(UserTestConstants.EMAIL_OK, user.getEmail());
        assertEquals(UserTestConstants.USERNAME_OK, user.getUsername());
        assertEquals(UserTestConstants.PASSWORD_OK, user.getPassword());
        assertEquals(UserTestConstants.ACCESS_PERMISSIONS_OK, user.getAccessPermissions());
        assertEquals(UserTestConstants.REGISTRATION_DATE_OK, user.getRegistrationDate());
        assertEquals(UserTestConstants.ENABLED_TRUE, user.isEnabled());
    }

    @ParameterizedTest
    @ValueSource(longs = {UserTestConstants.ID_POSITIVE, UserTestConstants.ID_ZERO})
    public void userValidIdTest(long id) {
        user.setId(id);

        assertNoViolations(user);
        assertEquals(id, user.getId());
    }

    @Test
    public void userNegativeIdTest() {
        user.setId(UserTestConstants.ID_NEGATIVE);

        assertConstraintViolationOnAttribute(user, "id", UserTestConstants.ID_POSITIVE_VALIDATION_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {UserTestConstants.NAME_OK, UserTestConstants.NAME_SIZE_EQUALS_MIN, UserTestConstants.NAME_SIZE_EQUALS_MAX})
    public void userValidNameSizeTest(String name) {
        user.setName(name);

        assertNoViolations(user);
        assertEquals(name, user.getName());
    }

    @ParameterizedTest
    @ValueSource(strings = {UserTestConstants.NAME_SIZE_LESS_THAN_MIN, UserTestConstants.NAME_SIZE_MORE_THAN_MAX})
    public void userInvalidNameSizeTest(String name) {
        user.setName(name);

        assertConstraintViolationOnAttribute(user, "name", UserTestConstants.NAME_SIZE_VALIDATION_MESSAGE);
    }

    @Test
    public void userNullNameTest() {
        user.setName(null);

        assertConstraintViolationOnAttribute(user, "name", UserTestConstants.NAME_NULL_VALIDATION_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {UserTestConstants.SURNAME_OK, UserTestConstants.SURNAME_SIZE_EQUALS_MIN, UserTestConstants.SURNAME_SIZE_EQUALS_MAX})
    public void userValidSurnameSizeTest(String surname) {
        user.setSurname(surname);

        assertNoViolations(user);
        assertEquals(surname, user.getSurname());
    }

    @ParameterizedTest
    @ValueSource(strings = {UserTestConstants.SURNAME_SIZE_LESS_THAN_MIN, UserTestConstants.SURNAME_SIZE_MORE_THAN_MAX})
    public void userInvalidSurnameSizeTest(String surname) {
        user.setSurname(surname);

        assertConstraintViolationOnAttribute(user, "surname", UserTestConstants.SURNAME_SIZE_VALIDATION_MESSAGE);
    }

    @Test
    public void userNullSurnameTest() {
        user.setSurname(null);

        assertConstraintViolationOnAttribute(user, "surname", UserTestConstants.SURNAME_NULL_VALIDATION_MESSAGE);
    }

    @Test
    public void userInvalidEmailFormatTest() {
        user.setEmail(UserTestConstants.EMAIL_INVALID_FORMAT);

        assertConstraintViolationOnAttribute(user, "email", UserTestConstants.EMAIL_EMAIL_VALIDATION_MESSAGE);
    }

    @Test
    public void userNullEmailTest() {
        user.setEmail(null);

        assertConstraintViolationOnAttribute(user, "email", UserTestConstants.EMAIL_NULL_VALIDATION_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {UserTestConstants.USERNAME_OK, UserTestConstants.USERNAME_SIZE_EQUALS_MIN, UserTestConstants.USERNAME_SIZE_EQUALS_MAX})
    public void userValidUsernameSizeTest(String username) {
        user.setUsername(username);

        assertNoViolations(user);
        assertEquals(username, user.getUsername());
    }

    @ParameterizedTest
    @ValueSource(strings = {UserTestConstants.USERNAME_SIZE_LESS_THAN_MIN, UserTestConstants.USERNAME_SIZE_MORE_THAN_MAX})
    public void userInvalidUsernameSizeTest(String username) {
        user.setUsername(username);

        assertConstraintViolationOnAttribute(user, "username", UserTestConstants.USERNAME_SIZE_VALIDATION_MESSAGE);
    }

    @Test
    public void userNullUsernameTest() {
        user.setUsername(null);

        assertConstraintViolationOnAttribute(user, "username", UserTestConstants.USERNAME_NULL_VALIDATION_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {UserTestConstants.PASSWORD_OK, UserTestConstants.PASSWORD_SIZE_EQUALS_MIN, UserTestConstants.PASSWORD_SIZE_EQUALS_MAX})
    public void userValidPasswordSizeTest(String password) {
        user.setPassword(password);

        assertNoViolations(user);
        assertEquals(password, user.getPassword());
    }

    @ParameterizedTest
    @ValueSource(strings = {UserTestConstants.PASSWORD_SIZE_LESS_THAN_MIN, UserTestConstants.PASSWORD_SIZE_MORE_THAN_MAX})
    public void userInvalidPasswordSizeTest(String password) {
        user.setPassword(password);

        assertConstraintViolationOnAttribute(user, "password", UserTestConstants.PASSWORD_SIZE_VALIDATION_MESSAGE);
    }

    @Test
    public void userNullPasswordTest() {
        user.setPassword(null);

        assertConstraintViolationOnAttribute(user, "password", UserTestConstants.PASSWORD_NULL_VALIDATION_MESSAGE);
    }

    @Test
    public void userNullAccessPermissionsTest() {
        user.setAccessPermissions(null);

        assertConstraintViolationOnAttribute(user, "accessPermissions", UserTestConstants.ACCESS_PERMISSIONS_NULL_VALIDATION_MESSAGE);
    }

    @Test
    public void userInvalidRegistrationDate() {
        user.setRegistrationDate(UserTestConstants.REGISTRATION_DATE_IN_FUTURE);

        assertConstraintViolationOnAttribute(user, "registrationDate", UserTestConstants.REGISTRATION_DATE_PAST_OR_PRESENT_VALIDATION_MESSAGE);
    }

    @Test
    public void userNullRegistrationDate() {
        user.setRegistrationDate(null);

        assertConstraintViolationOnAttribute(user, "registrationDate", UserTestConstants.REGISTRATION_DATE_NULL_VALIDATION_MESSAGE);
    }

}