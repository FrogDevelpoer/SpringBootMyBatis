package com.shopping.mapper;

import com.shopping.model.Member;
import org.apache.ibatis.annotations.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Mapper
public interface MemberMapperXml {
    List<Member> SelectAll() ;

    Member SelectOne(@Param("id") String id);

    int Insert(@Param("member") final Member member);

    int Update(@Param("member") final Member member);

    int Delete(@Param("id") String id);
}
