package com.osprey.studio.service;

import com.osprey.studio.domain.entities.User;
import com.osprey.studio.domain.enums.State;
import com.osprey.studio.domain.forms.UserRegistration;
import com.osprey.studio.repository.UserRepository;
import com.osprey.studio.repository.common.BaseRepository;
import com.osprey.studio.service.common.AbstractBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;
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

//        generateCode(user);


        if (!StringUtils.isEmpty(user.getEmail())) {   //В SpringUtils есть метод isEmpty который проверяет что строчки не равны null и непустые
            String message = String.format(
                    "Привет, %s \n" + "Доббро пожаловать на наш сайт One Click Bus. Пожалуйста активируйте ваш аккаунт по сслыке http://localhost:8080/activate/%s",
                    user.getEmail(),   //?????
                    user.getActivationCode()
            );

            mailService.send(user.getEmail(), "Activation Code", message);
        }
    }


    public  boolean activateUser(String code) {
        User user = userRepository.findByActivationCode(code);

        if (user == null) {
            return false;
        }
        user.setActivationCode(null); // Означает что пользователь подтвердил свой почтовый ящик

        userRepository.save(user);

        return true;

    }




}
