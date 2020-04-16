package com.atguigu.gmall.user.service.impl;

import com.atguigu.gmall.bean.UmsMember;
import com.atguigu.gmall.bean.UmsMemberReceiveAddress;
import com.atguigu.gmall.service.UserService;

import com.atguigu.gmall.user.mapper.UmsMemberMapper;
import com.atguigu.gmall.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UmsMemberMapper umsMemberMapper;


    @Override
    public List<UmsMember> getAllUser() {

     // List<UmsMember> umsMembers=  userMapper.selectAllUser();
        List<UmsMember> umsMembers=  userMapper.selectAll();
        return umsMembers;
    }

    @Override
    public List<UmsMemberReceiveAddress> getReceiveAddress(String umsMemberId) {
        Example e=new Example(UmsMemberReceiveAddress.class);
        e.createCriteria().andEqualTo("memberId",umsMemberId);
        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses=umsMemberMapper.selectByExample(e);
        return umsMemberReceiveAddresses;
    }


}
