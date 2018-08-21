package com.osprey.studio.service;

import com.osprey.studio.domain.entities.User;
import com.osprey.studio.domain.enums.Role;
import com.osprey.studio.domain.enums.State;
import com.osprey.studio.domain.forms.UserRegistration;
import com.osprey.studio.repository.UserRepository;
import com.osprey.studio.repository.common.BaseRepository;
import com.osprey.studio.service.common.AbstractBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;
import java.util.Set;

@Service
public class UserService extends AbstractBaseService<User> {
    //comment
    @Autowired
    public UserRepository userRepository;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Override
    protected BaseRepository<User, Long> getRepository() {

        return userRepository;
    }


    public Optional<User> findByEmail(String email) {

        return userRepository.findByEmail(email);
    }

    public void registration(UserRegistration user) {
        User userCondidat = new User();
        userCondidat.setState(State.ACTIVE);

        if (!StringUtils.isEmpty(user.getPassword())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
    }

    /**
     * Проверка есть ли у юзера такая роль
     */
    public boolean checkUserRole(User user, Role role){
        Set<Role> roles=user.getRoles();
           if (roles.contains(role)){
               return true;
           }
        return false;
    }

    /**
     * Редактирование своего профиля(имя)
     */
    public boolean editFirstNameProfile(User user, String firsName){
        user.setFirstName(firsName);
        userRepository.save(user);
        if (userRepository.findByFirstName(firsName) !=null){
            return true;
        }
        return false;
    }
    /**
     * Редактирование своего профиля(Фамилия)
     */
    public boolean editLastNameProfile(User user, String lastName){
        user.setLastName(lastName);
        userRepository.save(user);
        if (userRepository.findByLastName(lastName) !=null){
            return true;
        }
        return false;
    }

    /**
     * Редактирование своего профиля(почта)+ отправка новую активацию на почту
     */
    public boolean editEmailProfile(User user, String email){
        String userEmail = user.getEmail();
        boolean isEmailChanged = (email != null && !email.equals(userEmail)) ||
                (userEmail != null && !userEmail.equals(email));

       if (isEmailChanged){
            user.setEmail(email);
            //Нужно добавить метод отправки активаци почты( Взять у Джастина когда он доделает метод)
           userRepository.save(user);
           if (userRepository.findByEmail(email).isPresent()){ // тут советуют использовать isPresent()
               return true;
           }
        }
        return false;
    }
    /**
     * Изменения пароля пользователя
     */
    public boolean editPasswordProfile(
            User user, String oldPassword, String newPassword, String confirmPassword
    ){
        boolean isNewPassword= (!StringUtils.isEmpty(newPassword) && newPassword.equals(confirmPassword));
        boolean checkPassword= passwordEncoder.matches(oldPassword, user.getPassword());
        if (isNewPassword && checkPassword){
            user.setPassword(passwordEncoder.encode(newPassword));
            userRepository.save(user);
            return true;
        }
        return false;
    }
}
