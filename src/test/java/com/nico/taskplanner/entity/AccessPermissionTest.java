package com.nico.taskplanner.entity;

import com.nico.taskplanner.entity.constants.AccessPermissionTestConstants;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static com.nico.taskplanner.ValidationsManager.*;

class AccessPermissionTest {

    private AccessPermission accessPermission;

    @BeforeAll
    static void setUpValidator() {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        setValidator(validator);
    }

    @BeforeEach
    public void setUp() {
        accessPermission = new AccessPermission();
        accessPermission.setName(AccessPermissionTestConstants.NAME_OK);
        accessPermission.setUsers(AccessPermissionTestConstants.USERS_OK);
    }

    @Test
    public void accessPermissionCreationOkTest() {
        assertNoViolations(accessPermission);
        assertEquals(AccessPermissionTestConstants.NAME_OK, accessPermission.getName());
        assertEquals(AccessPermissionTestConstants.USERS_OK, accessPermission.getUsers());
    }

    @ParameterizedTest
    @ValueSource(strings = {AccessPermissionTestConstants.NAME_OK,AccessPermissionTestConstants.NAME_SIZE_EQUALS_MIN,
            AccessPermissionTestConstants.NAME_SIZE_EQUALS_MAX})
    public void accessPermissionValidNameSizeTest(String name) {
        accessPermission.setName(name);

        assertNoViolations(accessPermission);
        assertEquals(name, accessPermission.getName());
    }

    @ParameterizedTest
    @ValueSource(strings = {AccessPermissionTestConstants.NAME_SIZE_LESS_THAN_MIN, AccessPermissionTestConstants.NAME_SIZE_MORE_THAN_MAX})
    public void accessPermissionInvalidNameSizeTest(String name) {
        accessPermission.setName(name);

        assertConstraintViolationOnAttribute(accessPermission, "name", AccessPermissionTestConstants.NAME_SIZE_VALIDATION_MESSAGE);
    }

    @Test
    public void accessPermissionsNameNullTest() {
        accessPermission.setName(null);

        assertConstraintViolationOnAttribute(accessPermission, "name", AccessPermissionTestConstants.NAME_NULL_VALIDATION_MESSAGE);
    }

    @Test
    public void accessPermissionsUsersNullTest() {
        accessPermission.setUsers(null);

        assertConstraintViolationOnAttribute(accessPermission, "users", AccessPermissionTestConstants.USERS_NULL_VALIDATION_MESSAGE);
    }

}