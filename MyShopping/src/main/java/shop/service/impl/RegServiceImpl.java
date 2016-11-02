package shop.service.impl;
import org.springframework.beans.factory.annotation.Autowired;

import shop.bean.Users;
import shop.dao.RegDao;
import shop.service.RegService;

public class RegServiceImpl implements RegService{

		@Autowired
		private RegDao regDao; 

		@Override
		public boolean isRegSuccesful( Users bean) {

			return regDao.isRegSuccesful(bean);
		}

		
	

}
