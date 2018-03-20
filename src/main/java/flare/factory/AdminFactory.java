package flare.factory;

import org.springframework.beans.factory.FactoryBean;

import flare.model.users.Admin;
import flare.model.users.Admin.AdminDAO;
import flare.model.users.Admin.AdminDAO.AdminRowMapper;

public class AdminFactory implements FactoryBean<Admin> {

	@Override
	public Admin getObject() throws Exception {

		Admin admin = new Admin();
		AdminDAO admindao =	admin.new AdminDAO();
		AdminRowMapper adminrm = admindao.new AdminRowMapper();
		
		admindao.setAdminDataMap(adminrm);
		admin.setAdminDAO(admindao);
		return admin;
	}

	@Override
	public Class<Admin> getObjectType() {
		// TODO Auto-generated method stub
		return Admin.class;
	}

	public boolean isSingleton() { return false; }
	
}
