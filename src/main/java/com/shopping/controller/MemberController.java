package com.shopping.controller;

import com.shopping.model.Member;
import com.shopping.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping(value = "/list")
    public String SelectAll(Model model){
        List<Member> memberList = memberService.SelectAll();
        model.addAttribute("list", memberList);
        return "/member/memberList";
    }

    @GetMapping(value = "/{id}")
    public String SelectOne(@PathVariable("id") String id, Model model){
        Member member = memberService.SelectOne(id);
        model.addAttribute("member", member);
        return "/member/memberDetail";
    }

    @GetMapping(value = "/insert")
    public String doGetInsert(Model model){
        model.addAttribute("member", new Member());
        return "/member/memberInput";
    }


    @PostMapping(value = "/insert")
    public String Insert(Member member){
        int cnt = -999;
        cnt = memberService.Insert(member);

        if(cnt == 1){
            return "redirect:/member/list";
        }
        else{
            return "/member/memberInput";
        }

    }

    @GetMapping(value = "/update/{id}")
    public String doGetUpdate(@PathVariable("id") String id,Model model){
        Member member = memberService.SelectOne(id);
        model.addAttribute("member", member);
        return "/member/memberUpdate";
    }


    @PostMapping(value = "/update")
    public String Update(Member member){
        int cnt = -999;
        cnt = memberService.Update(member);

        if(cnt != -999){
            return "redirect:/member/list";
        }
        else{
            return "/member/memberUpdate";
        }

    }

    @GetMapping(value = "/delete/{id}")
    public String doGetDelete(@PathVariable("id") String id){
        int cnt = -999;
        cnt = memberService.Delete(id);
        return "redirect:/member/list";
    }
}

