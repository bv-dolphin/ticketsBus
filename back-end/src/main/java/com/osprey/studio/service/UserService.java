package com.osprey.studio.service;

import com.osprey.studio.domain.entities.User;
import com.osprey.studio.domain.enums.Role;
import com.osprey.studio.domain.enums.State;
import com.osprey.studio.domain.forms.UserRegistration;
import com.osprey.studio.repository.UserRepository;
import com.osprey.studio.repository.common.BaseRepository;
import com.osprey.studio.service.common.AbstractBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class UserService extends AbstractBaseService<User> {
    //comment
    @Autowired
    public UserRepository userRepository;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Autowired
    private MailService mailService;

    @Override
    protected BaseRepository<User, Long> getRepository() {

        return userRepository;
    }


    public Optional<User> findByEmail(String email) {

        return userRepository.findByEmail(email);
    }

    public void registration(UserRegistration user) {


        if (!StringUtils.isEmpty(user.getPassword())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
    }

    public  void generateCode(UserRegistration user) {
        String UUID = java.util.UUID.randomUUID().toString();
        user.setActivationCode(UUID);

    }

    public void sendMessage(UserRegistration user) {


        if (!StringUtils.isEmpty(user.getEmail())) {   //В SpringUtils есть метод isEmpty который проверяет что строчки не равны null и непустые
            String message = String.format(
                    "Привет, %s \n" + "Доббро пожаловать на наш сайт One Click Bus. Пожалуйста активируйте ваш аккаунт по сслыке http://localhost:8080/activate/%s",
                    user.getEmail(),
                    user.getActivationCode()
            );

            mailService.send(user.getEmail(), "Activation Code", message);
        }
    }

 /*   public void sendMessageForUpdateEmail(User user) {


        if (!StringUtils.isEmpty(user.getEmail())) {
            String message = String.format(
                    "Для того, чтобы поменять  %s \n" +
                            "Пожалуйста активируйте ваш аккаунт по сслыке http://localhost:8080/activate/%s",
                    user.getEmail(),
                    user.getActivationCode()
            );

            mailService.send(user.getEmail(), "Activation Code", message);
        }
    }*/


    public  boolean activateUser(String code) {
        User user = userRepository.findByActivationCode(code);


        if (user == null) {
            return false;
        }
        user.setActivationCode(null); // Означает что пользователь подтвердил свой почтовый ящик
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);

        return true;

    }


    public void updateProfile(User user, String firstName, String lastName, String email, String oldPassword, String newPassword, String confirmPassword, Model model) {
            if (!editFirstNameProfile(user, firstName)) {
                model.addAttribute
                        ("firstNameMessage", "changed First name failed, please try again");
            }
            if (!editLastNameProfile(user, lastName)){
                model.addAttribute
                        ("lastNameMessage","changed Last name failed, please try again");
            }

            if (editEmailProfile(user, email)){
                model.addAttribute
                        ("emailMessage", "Change the email was successful");
            } else model.addAttribute("emailChangeError", "Email cant be empty!");


            if (editPasswordProfile(user, oldPassword, newPassword, confirmPassword)){
                model.addAttribute
                        ("passwordMessage", "Change the password was successful");
            }else
                model.addAttribute
                        ("passwordMessage","changed password failed, please try again. ");
    }

    /**
     * Проверка есть ли у юзера такая роль
     */
    public boolean checkUserRole(User user, Role role){
        Set<Role> roles=user.getRoles();
        return roles.contains(role);
    }

 /*   *//**
     * Редактирование своего профиля(имя)
     */
    public boolean editFirstNameProfile(User user, String firstName){
        if (StringUtils.isEmpty(firstName) || user.getFirstName().equals(firstName)) {
            return false;
        }
        user.setFirstName(firstName);
        userRepository.save(user);
       // if (userRepository.findByFirstName(firstName) !=null){ }
        return true;
        }
    /**
     * Редактирование своего профиля(Фамилия)
     */
    public boolean editLastNameProfile(User user, String lastName){
        if (StringUtils.isEmpty(lastName) && user.getLastName().equals(lastName)) {
            return false;
        }
        user.setLastName(lastName);
        userRepository.save(user);
       // if (userRepository.findByLastName(lastName) !=null){ }
        return true;
    }

    /**
     * Редактирование своего профиля(почта)+ отправка новую активацию на почту
     */
    public boolean editEmailProfile(User user, String email){
        if (!StringUtils.isEmpty(email)){
            return false;
        }
        String userEmail = user.getEmail();
        boolean isEmailChanged = (email != null && !email.equals(userEmail)) ||
                (userEmail != null && !userEmail.equals(email));

       if (isEmailChanged){
            user.setEmail(email);

          /* if (!StringUtils.isEmpty(email)) {
               user.setActivationCode(UUID.randomUUID().toString());
           }*/
           userRepository.save(user);
           return true;
       }
          /* if (userRepository.findByEmail(email).isPresent()){ // тут советуют использовать isPresent()
                sendMessageForUpdateEmail(user);
               return true;
           }*/
        return false;
    }
    /**
     * Изменения пароля пользователя
     */
    public boolean editPasswordProfile(
            User user, String oldPassword, String newPassword, String confirmPassword
    ){
        if(StringUtils.isEmpty(oldPassword) || StringUtils.isEmpty(newPassword)
                || StringUtils.isEmpty(confirmPassword)){
            return false;
        }
        boolean isNewPassword = (!StringUtils.isEmpty(newPassword) && newPassword.equals(confirmPassword));
        boolean checkPassword = passwordEncoder.matches(oldPassword, user.getPassword());

        if (isNewPassword && checkPassword){
            user.setPassword(passwordEncoder.encode(newPassword));
            userRepository.save(user);
            return true;
        }
        return false;
    }
}
