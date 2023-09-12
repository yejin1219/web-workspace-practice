package member.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import member.model.vo.MemberVO;

public class MemberDAO {


public static MemberDAO dao= new MemberDAO();
public MemberDAO() {}
public static MemberDAO getInstance() {
	return dao;
	
}

	 public int registerMember(SqlSession sqlSession, MemberVO vo ) {
		 return sqlSession.insert("memberMapper.registerMember",vo);
	 }
	
	 
	 public List<MemberVO> showAllMember(SqlSession sqlSession ){
		 return sqlSession.selectList("memberMapper.showAllMember");
	 }
	 
	 public List<MemberVO> findByIdMember(SqlSession sqlSession, List<String>list) {
		 return sqlSession.selectList("memberMapper.findByIdMember", list);
	 }
	 
	 public MemberVO login (SqlSession sqlSession, MemberVO vo) {
		 return sqlSession.selectOne("memberMapper.login", vo);
	 }
	 
	 public int updateMember(SqlSession sqlSession, MemberVO vo) {
		 return sqlSession.update("memberMapper.updateMember",vo);
	 }
}

