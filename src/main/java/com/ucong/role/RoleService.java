package com.ucong.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> findAll(){
        return  roleRepository.findAll();
    }

    public Role save(Role role){
        return roleRepository.save(role);
    }

    public Optional<Role> findByName(RoleName name){
        return roleRepository.findByName(name);
    }



}
