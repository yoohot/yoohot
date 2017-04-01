package cn.yoohot.mapper;

import org.springframework.stereotype.Repository;

import cn.yoohot.model.UserInfo;

@Repository
public interface UserInfoMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);


    UserInfo selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}