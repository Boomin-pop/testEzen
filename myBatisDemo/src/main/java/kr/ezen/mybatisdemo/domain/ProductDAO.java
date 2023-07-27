package kr.ezen.mybatisdemo.domain;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductDAO {
    List<Map<String, Object>> getList();

    int prodDel(String pno);

    Map<String, Object> getListOne(String pno);

    int prodModify(String pno, String pname, String kind, String price);

    int prodRegister(String pname, String kind, String price);

    List<Map<String, Object>> prodSearch(String pname, String kind);

    int prodsDelete(List<String> chkList);

    int modifyPrice(String pno, String price);

    int insertLog(String pno, String price);

    int modifyPriceOne(List<String> chkList, String price);

    int insertLogOne(List<String> chkList, String price);
}
