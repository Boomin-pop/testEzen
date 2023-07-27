package kr.ezen.mybatisdemo.service;

import kr.ezen.mybatisdemo.domain.MemberDAO;
import kr.ezen.mybatisdemo.domain.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    MemberDAO memberDAO;

    public List<MemberDTO> MemberList() {
        List<MemberDTO> list = memberDAO.memberList();
        return list;
    }

    public MemberDTO memberInfo(String memberNum){
        MemberDTO mDto = memberDAO.memberInfo(memberNum);
        return mDto;
    }

    public int memberUpdate(MemberDTO mDto){
        int n = memberDAO.memberUpdate(mDto);
        return n;
    }

    public int memberRegister(MemberDTO mDto) {
        int n = memberDAO.memberRegister(mDto);
        return n;
    }

    public int memberDel(String memberNum) {
        int n = memberDAO.memberDel(memberNum);
        return n;
    }

    public List<MemberDTO> memberSearch(MemberDTO dvmDto) {
        List<MemberDTO> list = memberDAO.memberSearch(dvmDto);
        return list;
    }
}
