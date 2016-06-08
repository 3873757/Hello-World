package cs425.mum.MUMScrum.service;

import java.util.List;

import cs425.mum.MUMScrum.domain.Employee;
import cs425.mum.MUMScrum.domain.Role;

public interface RoleService {
	public List<Role> findAllRoles();
	public Role findRoleById(long id);
	public void saveRole(Role role);
	public void deleteRoleById(long id);
	public void assignRole(Employee employee, Role role);
}
