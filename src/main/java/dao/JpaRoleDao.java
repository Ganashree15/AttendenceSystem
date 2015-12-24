package dao;

import entity.Role;

public class JpaRoleDao extends JpaDao<Role, Long> implements RoleDao {

	public JpaRoleDao() {
		super(Role.class);
	}
}
