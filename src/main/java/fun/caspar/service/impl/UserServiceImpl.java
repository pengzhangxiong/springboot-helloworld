package fun.caspar.service.impl;

import fun.caspar.mapper.UserMapper;
import fun.caspar.model.User;
import fun.caspar.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<User> list() {
        return userMapper.list();
    }

    @Override
    public List<User> findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public User findUser(String username) {
        return userMapper.findUser(username);
    }

    @Override
    public User getUser(Integer id) {
        // 从缓冲中提取
        User user = (User) redisTemplate.opsForValue().get("user_" + id);
        // 如果没有缓存则到数据库查询并放入缓存
        if (null == user) {
            user = userMapper.getUser(id);
            redisTemplate.opsForValue().set("user_" + id, user);
        }
        return user;
    }

    @Override
    public Integer sava(String username, String password) {
        return userMapper.sava(username, password);
    }

    @Override
    public int delete(Integer id) {
        redisTemplate.delete("user_" + id);
        return userMapper.delete(id);
    }
}
