package com.nico.taskplanner.service;

import com.nico.taskplanner.dto.DtoValidator;
import com.nico.taskplanner.dto.UserProfileDto;
import com.nico.taskplanner.dto.UserRegistrationDto;
import com.nico.taskplanner.entity.User;
import com.nico.taskplanner.error.EmailOrUsernameAlreadyExistsException;
import com.nico.taskplanner.repository.UserRepository;
import com.nico.taskplanner.service.constants.AuthenticationServiceImplTestConstants;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AuthenticationServiceImplTest {

    @InjectMocks
    private AuthenticationServiceImpl authenticationService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private DtoValidator dtoValidator;

    @Test
    public void givenNewUserRegistration_whenSignUp_thenSuccess() throws EmailOrUsernameAlreadyExistsException {
        // Config. datos de prueba
        UserRegistrationDto userRegistrationDto = AuthenticationServiceImplTestConstants.createUserRegistrationDtoFromConstants();
        UserProfileDto userProfileDto = AuthenticationServiceImplTestConstants.createUserProfileDtoFromConstants();
        User user = AuthenticationServiceImplTestConstants.createUserFromConstants();

        // Comportamientos esperados de los mocks
        Mockito.when(userRepository.existsByEmailOrUsername(AuthenticationServiceImplTestConstants.USER_EMAIL,
                AuthenticationServiceImplTestConstants.USER_USERNAME)).thenReturn(false);
        Mockito.when(userRepository.save(user)).thenReturn(user);
        Mockito.when(modelMapper.map(userRegistrationDto, User.class)).thenReturn(user);
        Mockito.when(modelMapper.map(user, UserProfileDto.class)).thenReturn(userProfileDto);

        // Llamada al método bajo prueba
        UserProfileDto saved = authenticationService.signUp(userRegistrationDto);

        // Verificación de comportamientos y resultado
        Mockito.verify(dtoValidator).validateDto(userRegistrationDto);
        Mockito.verify(userRepository).existsByEmailOrUsername(AuthenticationServiceImplTestConstants.USER_EMAIL, AuthenticationServiceImplTestConstants.USER_USERNAME);
        Mockito.verify(userRepository).save(user);
        Mockito.verify(modelMapper).map(userRegistrationDto, User.class);
        Mockito.verify(modelMapper).map(user, UserProfileDto.class);

        assertEquals(userProfileDto, saved);
    }

    @Test
    public void givenNewUserRegistrationWithExistingEmailOrUsername_whenSignUp_thenFail() {
        // Config. datos de prueba
        UserRegistrationDto userRegistrationDto = AuthenticationServiceImplTestConstants.createUserRegistrationDtoFromConstants();

        // Comportamientos esperados de los mocks
        Mockito.when(userRepository.existsByEmailOrUsername(AuthenticationServiceImplTestConstants.USER_EMAIL,
                AuthenticationServiceImplTestConstants.USER_USERNAME)).thenReturn(true);

        // Llamada de método bajo prueba y resultados
        Exception e = assertThrows(EmailOrUsernameAlreadyExistsException.class, () -> authenticationService.signUp(userRegistrationDto));
        assertEquals("Email o username no disponible", e.getMessage());
    }

}