package member.model.service;

import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import member.common.Template;
import member.model.dao.MemberDAO;
import member.model.vo.MemberVO;

public class MemberService {

	public int registerMember(MemberVO vo) {
		SqlSession sqlSession = Template.getSqlSession();
		int result = MemberDAO.getInstance().registerMember(sqlSession, vo);
		
		if(result>0) sqlSession.commit();
		sqlSession.close();
		
		return result;
		
	}
	
	public List<MemberVO> showAllMember(){
		SqlSession sqlSession = Template.getSqlSession();
		List<MemberVO> list = MemberDAO.getInstance().showAllMember(sqlSession);
		sqlSession.close();
		
		return list;
		
	}
	
	public List<MemberVO> findByIdMember(String[]idList){
		SqlSession sqlSession = Template.getSqlSession();
		List<String> list = Arrays.asList(idList);
		
	List<MemberVO> member = 	MemberDAO.getInstance().findByIdMember(sqlSession,list);
		sqlSession.close();
		return member;
		
	}
	
	public int updateMember(MemberVO vo) {
		SqlSession sqlSession = Template.getSqlSession();
	  int result =	MemberDAO.getInstance().updateMember(sqlSession, vo);
		
	  if(result>0) sqlSession.commit();
	  sqlSession.close();
		return result;
		
		
		
	}
	
	
}
