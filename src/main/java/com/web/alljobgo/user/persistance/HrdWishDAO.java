package com.web.alljobgo.user.persistance;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.web.alljobgo.object.ResultType;
import com.web.alljobgo.train.domain.WishVO;

@Repository
public class HrdWishDAO implements WishDAO {

	private static final Logger logger = LoggerFactory.getLogger(HrdWishDAO.class);
	private final SqlSession sqlSession;
	private final String namespace = "com.web.alljobgo.wishMapper";
	
	public HrdWishDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public ResultType insertWish(WishVO wishVO) {
		try {
			wishVO.setClass_Num((Integer)sqlSession.selectOne(namespace + ".getMaxID") + 1);
			logger.info(wishVO.toString());
			sqlSession.insert(namespace + ".insertWish", wishVO);
		}catch(Exception excep) {
			excep.printStackTrace();
			return new ResultType(false, "찜목록 DB 추가 실패!");
		}
		return new ResultType(true, "찜목록 DB 추가 성공!");
	}

}
