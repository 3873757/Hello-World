package cs425.mum.MUMScrum.service.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cs425.mum.MUMScrum.domain.Employee;
import cs425.mum.MUMScrum.domain.Role;
import cs425.mum.MUMScrum.domain.User;
import cs425.mum.MUMScrum.repository.RoleRepository;
import cs425.mum.MUMScrum.repository.UserRepository;
import cs425.mum.MUMScrum.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;
		
	@Autowired
	private UserRepository userRepository;
	
	public List<Role> findAllRoles() {
		return (List<Role>) roleRepository.findAll();
	}

	public Role findRoleById(long id) {
		return roleRepository.findOne(id);
		
	}

	@Override
	public void saveRole(Role role) {
		roleRepository.save(role);		
	}

	@Override
	public void deleteRoleById(long id) {
		roleRepository.delete(id);
	}
	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	
	public void assignRole(Employee employee, Role role) {
		   Set<Role> rList = new HashSet<Role>();
			if(employee.getUser().getRoles()!=null){
				Iterator<Role> ite = employee.getUser().getRoles().iterator();
				Role r = null;
				while (ite.hasNext()) {
		            r = ite.next();
		            rList.add(r);
		        }
			}
			rList.add(role);
			User user = employee.getUser();
            user.setRoles(rList);
            userRepository.save(user);
	}
}
