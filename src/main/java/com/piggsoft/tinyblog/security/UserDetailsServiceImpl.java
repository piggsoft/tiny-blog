package com.piggsoft.tinyblog.security;

import com.piggsoft.tinyblog.dao.RoleDao;
import com.piggsoft.tinyblog.dao.UserDao;
import com.piggsoft.tinyblog.dao.UserRoleDao;
import com.piggsoft.tinyblog.po.Role;
import com.piggsoft.tinyblog.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserRoleDao userRoleDao;
    @Autowired
    private RoleDao roleDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findOneByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("user name not found");
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        List<Long> roleIds = userRoleDao.findRoleIdByUserId(user.getId());
        List<Role> roles = roleDao.findByIdIn(roleIds);
        for (Role role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
