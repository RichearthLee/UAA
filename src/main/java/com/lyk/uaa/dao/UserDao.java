package com.lyk.uaa.dao;

import com.lyk.uaa.model.UserDto;
import org.apache.ibatis.annotations.*;

public interface UserDao {

    @Insert("INSERT INTO user(id, username, password, fullname, moblie)" +
            " values(#{id}, #{username}, #{password}, #{fullname}, #{moblie})")
    public int insert(UserDto userDto);

    @Select("SELECT * FROM user WHERE username = #{username}")
    public UserDto selectByUsername(@Param("username") String username);

    @Update("UPDATE user SET username = #{username}, password = #{password}," +
            " fullname = #{fullname}, moblie = #{moblie} where id = #{id},")
    public int udpateById(UserDto userDto) ;

    @Delete("DELETE FROM user WHERE id = #{id}")
    public int deleteById(@Param("id") Long id) ;
}
