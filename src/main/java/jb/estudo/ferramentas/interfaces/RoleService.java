package jb.estudo.ferramentas.interfaces;

import jb.estudo.ferramentas.models.Role;

import java.util.List;

public interface RoleService {

    public List<Role> getAllRoles();

    public Role getRoleById(Integer id);
 }
