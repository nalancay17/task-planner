package com.nico.taskplanner.service;

import com.nico.taskplanner.dto.DtoValidator;
import com.nico.taskplanner.dto.UserProfileDto;
import com.nico.taskplanner.dto.UserRegistrationDto;
import com.nico.taskplanner.entity.User;
import com.nico.taskplanner.error.EmailOrUsernameAlreadyExistsException;
import com.nico.taskplanner.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DtoValidator dtoValidator;

    @Override
    public UserProfileDto signUp(UserRegistrationDto userRegistrationDto) throws EmailOrUsernameAlreadyExistsException {
        dtoValidator.validateDto(userRegistrationDto);
        if (userRepository.existsByEmailOrUsername(userRegistrationDto.getEmail(), userRegistrationDto.getUsername()))
            throw new EmailOrUsernameAlreadyExistsException("Email o username no disponible");
        User user = modelMapper.map(userRegistrationDto, User.class);
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserProfileDto.class);
    }

}
