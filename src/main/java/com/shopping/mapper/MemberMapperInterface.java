package com.shopping.mapper;

import com.shopping.model.Member;
import org.apache.ibatis.annotations.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Mapper // 스프링이 자동으로 객체를 생성하고, sql 구문을 분석해줍니다.
public interface MemberMapperInterface {
    @Select("select * from members")
    List<Member> SelectAll() ;

    @Select("select * from members where id = #{id}")
    Member SelectOne(@Param("id") String id);

    @Insert("insert into members(id, name, age, gender) values(#{id}, #{name}, #{age}, #{gender})")
    int Insert(@Param("member") final Member member);

    @Update("update members set name=#{name}, age=#{age}, gender=#{gender} where id=#{id}")
    int Update(@Param("member") final Member member);

    @Delete("delete from members where id=#{id}")
    int Delete(@Param("id") String id);
}
