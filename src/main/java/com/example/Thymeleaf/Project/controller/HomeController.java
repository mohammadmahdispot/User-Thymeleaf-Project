package com.example.Thymeleaf.Project.controller;

import com.example.Thymeleaf.Project.entity.User;
import com.example.Thymeleaf.Project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final UserService userService;

    @GetMapping("/")
    public String redirectToUserList() {
        System.out.println("Here!");
        return "index";
    }

    @GetMapping("/list")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUser());
        return "list"; // نمایش لیست کاربران
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("user", new User());
        return "create"; // صفحه ایجاد کاربر جدید
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute("user") User user) {
        userService.create(user);
        return "redirect:/USER/"; // بازگشت به لیست کاربران
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "edit"; // صفحه ویرایش کاربر
    }

    @PostMapping("/edit/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute("user") User user) {
        user.setId(id); // اطمینان از تنظیم آی‌دی کاربر
        userService.create(user);
        return "redirect:/USER/";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return "redirect:/USER/"; // بازگشت به لیست کاربران
    }
}

