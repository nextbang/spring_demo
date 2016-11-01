package com.demo.service;

import com.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by yanlingz on 16/10/30.
 */
@Service
public interface UserService {

    User findOne(int id);

}
