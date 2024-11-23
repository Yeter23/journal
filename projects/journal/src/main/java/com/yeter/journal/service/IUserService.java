package com.yeter.journal.service;

import com.yeter.journal.entity.User;
import com.yeter.journal.enums.Role;

import java.util.List;

public interface IUserService extends IService<User> {
    List<User> getUserByRole(Role role);

    List<User> getPotentialUsers(List<Integer> ids);
}
