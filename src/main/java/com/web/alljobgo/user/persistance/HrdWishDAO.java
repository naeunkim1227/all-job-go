package com.web.alljobgo.user.persistance;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONObject;
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
	public List<String> getUserWishs(WishVO wishVO) {
		List<String> userWish = null;
		try {
			userWish = sqlSession.selectList(namespace+".getUserWish", wishVO);
		}catch(Exception excep) {
			excep.printStackTrace();
			return null;
		}
		return userWish;
	}
	
	@Override
	public ResultType insertWish(WishVO wishVO) {
		try {
			boolean isExist = sqlSession.selectOne(namespace+".isExist",wishVO);
			if(isExist) {
				throw new Exception("이미 존재합니다.");
			}
			
			wishVO.setClass_Num((Integer)sqlSession.selectOne(namespace + ".getMaxID") + 1);
			sqlSession.insert(namespace + ".insertWish", wishVO);
		}catch(Exception excep) {
			excep.printStackTrace();
			return new ResultType(false, "찜목록 DB 추가 실패!");
		}
		return new ResultType(true, "찜목록 DB 추가 성공!");
	}

	@Override
	public ResultType deleteWish(WishVO wishVO) {
		try {
			int deleteRows = sqlSession.delete(namespace + ".deleteWish", wishVO);
			if(deleteRows == 0) {
				throw new Exception("삭제한게 없음.");
			}
		}catch(Exception excep) {
			excep.printStackTrace();
			return new ResultType(false, "찜목록 DB 삭제 실패!");
		}
		return new ResultType(true, "찜목록 DB 삭제 성공!");
	}
}
