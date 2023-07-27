package kr.ezen.mybatisdemo.controller;

import kr.ezen.mybatisdemo.domain.MemberDTO;
import kr.ezen.mybatisdemo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Controller
//@Log4j
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("/member")
    public String member(Model model){
        List<MemberDTO> list  = memberService.MemberList();
        model.addAttribute("list", list);

        return "/member/member";
    }

    @PostMapping("/member/search")
    public String memberSearch(@RequestParam(value="memberName", defaultValue = "all") String memberName,
                             @RequestParam("memberGender") String memberGender, Model model) {
        System.out.println("memberName = " + memberName);
        System.out.println("memberGender = " + memberGender);
        MemberDTO dvmDto = new MemberDTO();
        dvmDto.setMemberName(memberName);
        dvmDto.setMemberGender(memberGender);
        List<MemberDTO> list = memberService.memberSearch(dvmDto);
        model.addAttribute("list", list);
        System.out.println("list = " + list);
        // 검색할 때 입력값 안넣고 버튼 누르면 null값이 넘어옴. 따라서 default값을 requestparam에서 정해줌

        return "/member/member";
    }

    @RequestMapping("/member/memberInfo")
    public String memberInfo(String memberNum, Model model){
        MemberDTO dto = memberService.memberInfo(memberNum);
        model.addAttribute("dto", dto);
        return "/member/memberInfo" ;
    }

    @PostMapping("/member/memberUpdate")
    public String memberUpdate(MemberDTO mDto){
        int n = memberService.memberUpdate(mDto);
     return "member/member";
    }


    @GetMapping("/member/memberRegister")
    public String prodRegister(){

        return "/member/memberRegister";
    }

    @PostMapping("/member/memberRegister")
    public String memberRegister(MemberDTO mDto){

        String id = mDto.getMemberID(); String name = mDto.getMemberName();
        /*for(int i=65; i<88; i++){*/
      /*  for(int i=97; i<120; i++){MemberDTO mmDto = new MemberDTO(); mmDto = mDto; mmDto.setMemberID(id + (char) i + (char) (i+1) + (char) (i+2) + i);
          mmDto.setMemberName(name + (char) i + (char) (i+1) + (char) (i+2) + (char) i + (char) (i+1) + (char) (i+2) + i ); int n = memberService.memberRegister(mmDto); }*/
        int n = memberService.memberRegister(mDto);
        return "redirect:/member";
    }

    @GetMapping("/member/memberDel")
    public String memberDel(String memberNum){
        /*리퀘스트파람으로 뷰에서 넘긴 pno받기*/
        //로그를 찍으려면 컨트롤러에서 log4j 불러오기
        //log.info("pno : " +pno);
        int n = memberService.memberDel(memberNum);

        return "redirect:/member";
    }
}
