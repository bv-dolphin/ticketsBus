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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@Controller
public class ProfileUserController {
    @Autowired
    private UserService userService;

  /*  @GetMapping("/profile")
    public String getProfilePage() {
        return "profile";
    }*/

  /*  *//**
     * Get запрос профайла.
     * Возвращает "nickname", для заголовка(если есть ферс нейм то его, если нету то имейл)
     * Возвращает  "message", если не активированая почта(проверка по роли Гость)
     * Возвращает "firstName" если есть, можно использовать для инпута
     * Возвращает "lastName"   если есть, можно использовать для инпута
     */
    @GetMapping("/profile")
    public String profile(Model model,@AuthenticationPrincipal User user) {
        System.out.println(">>>>>>>>>>>>>" + user.getEmail()+"<<<<<<<<<<<<<<<<");
        model.addAttribute("email", user.getEmail());
        if (userService.checkUserRole(user, Role.GUEST)) {
            model.addAttribute
                    ("messageNotActiveEmail",
                            "To work on the site you need to activate mail");
        } else model.addAttribute("email", user.getEmail());

        if (!user.getFirstName().isEmpty() || user.getFirstName() != null) {
            model.addAttribute("nick_name", user.getFirstName());
            model.addAttribute("first_name", user.getFirstName());
        } else {
            model.addAttribute("nick_name", user.getEmail());
        }
        if (user.getLastName() !=null){
            model.addAttribute("last_name", user.getLastName());
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

        if (bindingResult.hasErrors()) {
            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errors);
            return "profile";
        } else userService.updateProfile
                        (user, firstName, lastName, email, oldPassword, newPassword, confirmPassword, model);

        return "profile";
    }


}
