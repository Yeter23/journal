package com.yeter.journal.repository;

import com.yeter.journal.entity.User;
import com.yeter.journal.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    //
    boolean existsByIdentityNo(String identityNo);
    // roluna gore istifadeci qaytaran
    List<User> findAllByRole(Role role);
    // verilen id xarici istifadeci qaytaran metod
    List<User>  findAllByRoleAndIdIsNotIn(Role role,List<Integer> idList);
}
