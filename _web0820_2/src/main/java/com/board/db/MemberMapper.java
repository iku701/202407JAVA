package com.board.db;

import org.apache.ibatis.annotations.*;

@Mapper
public interface MemberMapper {
	@Select("select count(*) from members where email = #{email} and password = #{password}")
	public int isMember(MemberDto memberDto);
	
	@Select("select * from members where email = #{email} and password = #{password}")
	public MemberDto findMember(MemberDto memberDto);
	
	@Insert("INSERT INTO members (member_id, name, email, password, created_at) VALUES (MEMBERS_SEQ.nextval, #{email}, #{password}, sysdate)")
    public int insertMember(MemberDto memberDto);
}
