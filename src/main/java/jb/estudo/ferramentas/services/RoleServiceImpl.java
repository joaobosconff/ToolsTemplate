package jb.estudo.ferramentas.services;

import jb.estudo.ferramentas.interfaces.RoleService;
import jb.estudo.ferramentas.models.Role;
import jb.estudo.ferramentas.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Override
    public List<Role> getAllRoles() {
        return null;
    }

    @Override
    public Role getRoleById(Integer id) {
        Optional<Role> role = roleRepository.findById(id);
        return role.orElse(null);
    }
}
