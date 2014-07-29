package com.rest.app.repository;

import com.test.app.model.JMember;

@Mapper
public interface MemberMapper {

    JMember findById(long id);

    void insert(JMember member);

}