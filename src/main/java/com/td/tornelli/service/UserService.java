package com.td.tornelli.service;

import com.td.tornelli.dto.UserDtoInput;
import com.td.tornelli.dto.UserDtoOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Value("${mock.users.enabled}")
    private boolean enabled;

    @Autowired
    private MockService mockService;

    public UserDtoOutput registerUser(UserDtoInput user){
        if(enabled) {
            return mockService.insertUser(user);
        }
        else {
            return null;
        }
    }

    public List<UserDtoInput> getListUsers(){
        if(enabled) {
            return null;//mockService.getListUtenti();
        }
        else {
            return null;
        }
    }
}
