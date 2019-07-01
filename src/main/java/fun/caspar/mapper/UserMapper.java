package fun.caspar.mapper;

import fun.caspar.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from  user where 1=1")
    List<User> list();

    @Select("select * from  user where 1=1 and username like #{username}")
    List<User> findByUsername(@Param("username") String username);

    @Select("select * from user where username = #{username}")
    User findUser(@Param("username") String username);

    @Select("select * from user where id = #{id}")
    User getUser(@Param("id") Integer id);

    @Insert("insert into user(username,password) values (#{username},#{password})")
    Integer sava(@Param("username") String username, @Param("password") String password);

    @Delete("delete from user where id = #{id}")
    int delete(@Param("id") Integer id);
}
