package cs425.mum.MUMScrum.domain;

import javax.validation.constraints.NotNull;

public class AssignRole {
	
	@NotNull
	private Employee employee;
	@NotNull
	private Role role;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
