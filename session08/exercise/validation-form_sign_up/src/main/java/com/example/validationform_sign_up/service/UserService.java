package com.example.validationform_sign_up.service;

import com.example.validationform_sign_up.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserService implements IUserService{
    private List<User> list = new ArrayList<>();
    @Override
    public List<User> showList() {
        return list;
    }

    @Override
    public boolean add(User user) {
        if (user!=null) {
            list.add(user);
            return true;
        }
        return false;
    }
}
