package com.web.alljobgo.user.persistance;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.web.alljobgo.user.domain.userVO;

@Repository
public class HrdUserDAO implements UserDAO {
	private final static Logger logger = LoggerFactory.getLogger(HrdUserDAO.class);
	private final String namespace = "com.web.alljobgo.userMapper"; 
	private SqlSession sqlSession;
	
	public HrdUserDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public boolean joinUser(userVO vo) throws Exception {
		logger.info("hrdUserDAO -> joinUser 호출");
		try {
			sqlSession.insert(namespace + ".signUser", vo);
			return true;
		}catch(Exception e) {
			logger.info(e.toString());
			return false;
		}
	}

	@Override
	public userVO findByEmail(String Email) throws Exception {
		return sqlSession.selectOne(namespace + ".findByEmail", Email);
	}
}
