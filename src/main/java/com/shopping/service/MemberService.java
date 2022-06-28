package com.shopping.service;

import com.shopping.mapper.MemberMapperInterface;
import com.shopping.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberMapperInterface memberMapperInterface;
    public List<Member> SelectAll() {
        return memberMapperInterface.SelectAll();
    }

    public Member SelectOne(String id){
        return memberMapperInterface.SelectOne(id);
    }

    public int Insert(Member member){
        return memberMapperInterface.Insert(member);
    }

    public int Update(Member member){
        return memberMapperInterface.Update(member);
    }

    public int Delete(String id){
        return memberMapperInterface.Delete(id);
    }
}
