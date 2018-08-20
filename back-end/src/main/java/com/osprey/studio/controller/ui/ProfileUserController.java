package com.osprey.studio.controller.ui;


import com.osprey.studio.domain.entities.User;
import com.osprey.studio.domain.enums.Role;
import com.osprey.studio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@Controller
public class ProfileUserController {
    @Autowired
    private UserService userService;

//    @GetMapping("/profile")
//    public String getProfilePage(ModelMap model, Authentication authentication) {
//        if (authentication == null) {
//            return "redirect:/login";
//        }
//        UserDetailsImpl details = (UserDetailsImpl)authentication.getPrincipal();
//        UserDto user = from(details.getUser());
//        model.addAttribute("user", user);
//    public String profile() {
//        return "profile";
//    }

    /**
     * Get запрос профайла.
     * Возвращает "nickname", для заголовка(если есть ферс нейм то его, если нету то имейл)
     * Возвращает  "message", если не активированая почта(проверка по роли Гость)
     * Возвращает "firstName" если есть, можно использовать для инпута
     * Возвращает "lastName"   если есть, можно использовать для инпута
     */
    @GetMapping("/profile")
    public String profile(Model model, @AuthenticationPrincipal User user) {

        if (!user.getFirstName().isEmpty() || user.getFirstName() != null) {
            model.addAttribute("nickname", user.getFirstName());
            model.addAttribute("firstName", user.getFirstName());
        } else {
            model.addAttribute("nickname", user.getEmail());
        }

        if (!userService.checkUserRole(user, Role.GUEST)) {
            model.addAttribute("message", "To work on the site you need to activate mail");
        }
        if (user.getLastName() !=null){
            model.addAttribute("lastName", user.getLastName());
        }

        return "profile";
    }

    /**
     * Post запрос Изменения профиля(Имя, Фамилия, Почта+активация новой почты)
     * Отдельно нужно модальное окна для изменения пароля и перенести логику смена пароля внего
     */
    @PostMapping("/profile")
    public String profileSave(@AuthenticationPrincipal User user,
                              @RequestParam String firstName,
                              @RequestParam String lastName,
                              @RequestParam String email,
                              @RequestParam String oldPassword,
                              @RequestParam String newPassword,
                              @RequestParam String confirmPassword,
                              BindingResult bindingResult, Model model) {

        if (!StringUtils.isEmpty(firstName)){
            if (userService.editFirstNameProfile(user, firstName)){
                model.addAttribute("firstNameMessage", "Change the First name was successful");
            }else
                model.addAttribute("firstNameMessage","changed First name failed, please try again");
        }
        if (!StringUtils.isEmpty(lastName)){
            if (userService.editLastNameProfile(user, lastName)){
                model.addAttribute("lastNameMessage", "Change the Last name was successful");
            }else
                model.addAttribute("lastNameMessage","changed Last name failed, please try again");
        }
        if (!StringUtils.isEmpty(email)){
            if (userService.editEmailProfile(user, email)){
                model.addAttribute("emailMessage", "Change the email was successful");
            }else
                model.addAttribute("emailMessage","changed email failed, please try again. Need activation email");
        }
        if(!StringUtils.isEmpty(oldPassword) && !StringUtils.isEmpty(newPassword) && !StringUtils.isEmpty(confirmPassword)){

            if (userService.editPasswordProfile(user, oldPassword, newPassword, confirmPassword)){
                model.addAttribute("passwordMessage", "Change the password was successful");
            }else
                model.addAttribute("passwordMessage","changed password failed, please try again. Need activation email");
        }
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errors);
        }
        return "profile";
    }

}
