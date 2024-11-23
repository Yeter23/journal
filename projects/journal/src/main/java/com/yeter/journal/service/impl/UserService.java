package com.yeter.journal.service.impl;

import com.yeter.journal.common.GeneralException;
import com.yeter.journal.entity.User;
import com.yeter.journal.enums.Role;
import com.yeter.journal.repository.UserRepository;
import com.yeter.journal.service.IUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUserByRole(Role role) {
        return List.of();
    }

    @Override
    public List<User> getPotentialUsers(List<Integer> ids) {
        return List.of();
    }

    @Override
    public User save(User user) {
        if (user.getId() == null) {
            if (user.getIdentityNo() == null || user.getIdentityNo().length()!=11) {
                //excp
                throw new GeneralException("invalid identityno!");

            }
            if (userRepository.existsByIdentityNo(user.getIdentityNo())) {
                throw  new GeneralException("identityno already exists:((");
            }
        }
        return userRepository.save(user);
    }

    @Override
    public User getById(Integer id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return List.of();
    }

    @Override
    public Page<User> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
