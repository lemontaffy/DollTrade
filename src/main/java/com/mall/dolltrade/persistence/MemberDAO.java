package com.mall.dolltrade.persistence;

import com.mall.dolltrade.domain.MemberVO;

public interface MemberDAO {
	
	public void signup(MemberVO vo) throws Exception;
	
	public MemberVO signin(MemberVO vo) throws Exception;

}
