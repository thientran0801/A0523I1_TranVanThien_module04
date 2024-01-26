package com.example.validationform_sign_up.service;

import com.example.validationform_sign_up.model.User;

import java.util.List;

public interface IUserService {
    List<User> showList();
    boolean add(User user);
}
