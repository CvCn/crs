package com.bjsxt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.bjsxt.pojo.Pagination;
import com.bjsxt.pojo.Users;

public interface UsersMapper
{
	
	@Results({
		@Result(id=true, property="username", column="username"),
		@Result(property="roleid", column="roleid"),
		@Result(property="roles", many=@Many(select="com.bjsxt.mapper.RolesMapper.selRoleBy"), column="r.roleid=roleid")
	})
	@Select("select * from users u where username=#{0} and userpwd=#{1}")
	List<Users> selUser(String username, String userpwd);
	
	@Insert("insert into users values(#{user.username}, #{user.identity}, #{user.fullname}, "
			+ "#{user.sex}, #{user.address}, #{user.phone}, #{user.roleid}, #{user.userpwd}, #{user.position})")
	int insUser(@Param("user") Users user);
	
	List<Users> selUserBy(@Param("u") Users user, @Param("p") Pagination p);
	
	int userCount(@Param("u") Users user);
	
	int updateUser(@Param("u") Users u, @Param("username") String username);
	
	@Delete("delete from users where username=#{0}")
	int deleteUser(String usernmae);
	
	@Select("select username from users")
	List<String> selUsername();
}
