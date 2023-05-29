package com.example.roleBasedEcom.serviceImpl;

import com.example.roleBasedEcom.dao.RoleDao;
import com.example.roleBasedEcom.dao.UserDao;
import com.example.roleBasedEcom.entity.Role;
import com.example.roleBasedEcom.entity.User;
import com.example.roleBasedEcom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registerNewUser(User user) {
        Role role = roleDao.findById("user").get();
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        user.setPassword(getEncodedPassword(user.getPassword()));
        return userDao.save(user);
    }

    @Override
    public void initRolesAndUsers() {
        Role adminRole = new Role();
        adminRole.setRole_name("Admin");
        adminRole.setRoleDesc("Admin Role");
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setRole_name("User");
        userRole.setRoleDesc("default user role");
        roleDao.save(userRole);

        User adminUser = new User();
        adminUser.setUsername("Admin");
        adminUser.setEmail("admin123@gmail.com");
        adminUser.setPassword(getEncodedPassword("Admin@pass"));

        Set<Role> adminRoles = new HashSet<>();
        adminUser.setRoles(adminRoles);
        adminRoles.add(adminRole);
        userDao.save(adminUser);

//        User user = new User();
//        user.setUsername("Raj");
//        user.setEmail("raj_sharma@gmail.com");
//        user.setPassword(getEncodedPassword("Raj@pass"));
//
//        Set<Role> userRoles = new HashSet<>();
//        user.setRoles(userRoles);
//        userRoles.add(userRole);
//        userDao.save(user);
    }

    public String getEncodedPassword(String password){
        return passwordEncoder.encode(password);
    }
}
