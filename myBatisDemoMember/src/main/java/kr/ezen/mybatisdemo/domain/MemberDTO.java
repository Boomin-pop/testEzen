package kr.ezen.mybatisdemo.domain;

import lombok.Data;

import java.sql.Date;

@Data
public class MemberDTO {
    private String memberNum;
    private String memberID;
    private String memberName;
    private String memberPw;
    private Date birthDay;
    private String memberGender;
    private String memberEmail;
}
