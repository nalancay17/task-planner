package com.nico.taskplanner.service;

import com.nico.taskplanner.dto.UserProfileDto;
import com.nico.taskplanner.dto.UserRegistrationDto;
import com.nico.taskplanner.error.EmailOrUsernameAlreadyExistsException;

public interface AuthenticationService {

    UserProfileDto signUp(UserRegistrationDto userRegistrationDto) throws EmailOrUsernameAlreadyExistsException;
}
