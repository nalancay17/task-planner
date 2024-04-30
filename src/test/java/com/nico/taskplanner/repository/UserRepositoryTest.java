package com.nico.taskplanner.repository;

import com.nico.taskplanner.entity.AccessPermission;
import com.nico.taskplanner.entity.User;
import com.nico.taskplanner.repository.constants.UserRepositoryTestConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User();
        user.setName(UserRepositoryTestConstants.NAME_CARLOS);
        user.setSurname(UserRepositoryTestConstants.SURNAME_FUENTES);
        user.setEmail(UserRepositoryTestConstants.EMAIL_CFUENTESEXAMPLE);
        user.setUsername(UserRepositoryTestConstants.USERNAME_CFUENTES17);
        user.setPassword(UserRepositoryTestConstants.PASSWORD_1);
        user.setRegistrationDate(UserRepositoryTestConstants.REGISTRATION_DATE_1);
        user.setEnabled(UserRepositoryTestConstants.ENABLED_TRUE);
    }

    @Test
    public void givenNewUser_whenSave_thenSuccess() {
        User inserted = userRepository.save(user);

        User found = entityManager.find(User.class, inserted.getId());
        assertEquals(inserted, found);
    }

    @Test
    public void givenNewUserWithAccessPermissions_whenSave_thenSuccess() {
        AccessPermission accessPermission = new AccessPermission(UserRepositoryTestConstants.ACCESS_PERMISSION_NAME_USER);
        entityManager.persist(accessPermission);

        user.getAccessPermissions().add(accessPermission);

        User inserted = userRepository.save(user);

        User found = entityManager.find(User.class, inserted.getId());
        assertEquals(user, found);
        assertTrue(found.getAccessPermissions().contains(accessPermission));
    }

    @Test
    public void givenUsersCreated_whenRead_thenSuccess() {
        User user2 = new User();
        user2.setName(UserRepositoryTestConstants.NAME_JULIETA);
        user2.setSurname(UserRepositoryTestConstants.SURNAME_PEREZ);
        user2.setEmail(UserRepositoryTestConstants.EMAIL_JPEREZEXAMPLE);
        user2.setUsername(UserRepositoryTestConstants.USERNAME_JPEREZ16);
        user2.setPassword(UserRepositoryTestConstants.PASSWORD_2);
        user2.setRegistrationDate(UserRepositoryTestConstants.REGISTRATION_DATE_2);
        user2.setEnabled(UserRepositoryTestConstants.ENABLED_TRUE);
        entityManager.persist(user);
        entityManager.persist(user2);

        List<User> usersRead = userRepository.findAll();

        assertTrue(usersRead.containsAll(Set.of(user, user2)));
    }

    @Test
    public void givenUserCreated_whenUpdate_thenSuccess() {
        User saved = entityManager.persist(user);

        saved.setName(UserRepositoryTestConstants.NAME_JULIETA);
        userRepository.save(saved);

        assertEquals(UserRepositoryTestConstants.NAME_JULIETA, entityManager.find(User.class, saved.getId()).getName());
    }

    @Test
    public void givenUserCreatedWithAccessPermissions_whenUpdate_thenSuccess() {
        AccessPermission accessPermission = new AccessPermission(UserRepositoryTestConstants.ACCESS_PERMISSION_NAME_USER);
        entityManager.persist(accessPermission);
        user.getAccessPermissions().add(accessPermission);
        User saved = entityManager.persist(user);

        AccessPermission accessPermission2 = new AccessPermission(UserRepositoryTestConstants.ACCESS_PERMISSION_NAME_ADMIN);
        entityManager.persist(accessPermission2);
        saved.getAccessPermissions().add(accessPermission2);
        userRepository.save(saved);

        assertEquals(Set.of(accessPermission, accessPermission2), entityManager.find(User.class, saved.getId()).getAccessPermissions());
    }

    @Test
    public void givenUsersCreated_whenDelete_thenSuccess() {
        User user2 = new User();
        user2.setName(UserRepositoryTestConstants.NAME_JULIETA);
        user2.setSurname(UserRepositoryTestConstants.SURNAME_PEREZ);
        user2.setEmail(UserRepositoryTestConstants.EMAIL_JPEREZEXAMPLE);
        user2.setUsername(UserRepositoryTestConstants.USERNAME_JPEREZ16);
        user2.setPassword(UserRepositoryTestConstants.PASSWORD_2);
        user2.setRegistrationDate(UserRepositoryTestConstants.REGISTRATION_DATE_2);
        user2.setEnabled(UserRepositoryTestConstants.ENABLED_TRUE);
        User saved1 = entityManager.persist(user);
        User saved2 = entityManager.persist(user2);

        userRepository.delete(saved2);

        assertNull(entityManager.find(User.class, saved2.getId()));
        assertNotNull(entityManager.find(User.class, saved1.getId()));
    }

    @Test
    public void givenUserCreatedWithAccessPermission_whenDelete_thenSuccess() {
        AccessPermission accessPermission = new AccessPermission(UserRepositoryTestConstants.ACCESS_PERMISSION_NAME_USER);
        entityManager.persist(accessPermission);
        user.getAccessPermissions().add(accessPermission);
        User saved = entityManager.persist(user);

        userRepository.delete(saved);

        assertNull(entityManager.find(User.class, saved.getId()));
        assertNotNull(entityManager.find(AccessPermission.class, accessPermission.getName()));
    }

    @Test
    public void givenUserCreated_whenExistsByEmailOrUsername_thenSuccess() {
        entityManager.persist(user);

        assertTrue(userRepository.existsByEmailOrUsername(user.getEmail(), user.getUsername()));
        assertTrue(userRepository.existsByEmailOrUsername(UserRepositoryTestConstants.INVENTED_EMAIL, user.getUsername()));
        assertTrue(userRepository.existsByEmailOrUsername(user.getEmail(), UserRepositoryTestConstants.INVENTED_USERNAME));
    }

    @Test
    public void givenUserCreated_whenExistsByEmailOrUsername_thenFail() {
        entityManager.persist(user);

        assertFalse(userRepository.existsByEmailOrUsername(UserRepositoryTestConstants.INVENTED_EMAIL, UserRepositoryTestConstants.INVENTED_USERNAME));
    }

}