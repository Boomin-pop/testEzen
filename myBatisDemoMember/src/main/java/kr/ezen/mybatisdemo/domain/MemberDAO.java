package kr.ezen.mybatisdemo.domain;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberDAO {
    List<MemberDTO> memberList();

    MemberDTO memberInfo(String memberNum);

    int memberRegister(MemberDTO mDto);


    int memberUpdate(MemberDTO mDto);

    int memberDel(String memberNum);

    List<MemberDTO> memberSearch(MemberDTO dvmDto);
}
