package flare.factory;

import org.springframework.beans.factory.FactoryBean;

import flare.model.users.ClubLeader;
import flare.model.users.ClubLeader.ClubLeaderDAO;
import flare.model.users.ClubLeader.ClubLeaderDAO.ClubLeaderRowMapper;


public class ClubLeaderFactory implements FactoryBean<ClubLeader> {

	@Override
	public ClubLeader getObject() throws Exception {

		ClubLeader clubleader = new ClubLeader();
		ClubLeaderDAO clubleaderdao =	clubleader.new ClubLeaderDAO();
		ClubLeaderRowMapper clubleaderrm = clubleaderdao.new ClubLeaderRowMapper();
		
		clubleaderdao.setcltDataMap(clubleaderrm);
		clubleader.setClDao(clubleaderdao);
		return clubleader;
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return ClubLeader.class;
	}
	
	public boolean isSingleton() { return false; }

}
