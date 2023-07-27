package kr.ezen.mybatisdemo.service;

import kr.ezen.mybatisdemo.domain.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    @Autowired
    ProductDAO productDAO;
    public List<Map<String, Object>> getList() {
        List<Map<String, Object>> list = productDAO.getList();
        //List<Map<String, Object>> list = new ArrayList<>();
//        Map<String, Object> map = new HashMap<>();
//
//        map.put("pno", "1");
//        map.put("pname", "텔레비전");
//        map.put("kind", "가전");
//        map.put("price", "300,000");
//        map.put("inDate", "2022-10-10");
//        map.put("upDate", "2022-10-11");
//        list.add(map);
//
//        map = new HashMap<>();
//        map.put("pno", "2");
//        map.put("pname", "파이선");
//        map.put("kind", "도서");
//        map.put("price", "30,000");
//        map.put("inDate", "2022-10-13");
//        map.put("upDate", "2022-10-13");
//        list.add(map);
        return list;
    }

    public int prodDel(String pno) {
        int n = productDAO.prodDel(pno);
        return n;
    }

    public Map<String, Object> getListOne(String pno) {
        Map<String, Object> map = productDAO.getListOne(pno);
        return map;
    }

    public int prodModify(String pno, String pname, String kind, String price) {
        int n = productDAO.prodModify(pno, pname, kind, price);
        return n;
    }

    public int prodRegister(String pname, String kind, String price) {
        int n = productDAO.prodRegister(pname, kind, price);
        return n;
    }

    public List<Map<String, Object>> prodSearch(String pname, String kind) {
        List<Map<String, Object>> list = productDAO.prodSearch(pname, kind);
        return list;
    }

    public int prodsDelete(List<String> chkList) {
        int n = productDAO.prodsDelete(chkList);
        return n;
    }

    public int modifyPrice(String pno, String price) {
        int n = productDAO.modifyPrice(pno, price);
        return n;
    }

    public int insertLog(String pno, String price) {
        int n2 = productDAO.insertLog(pno, price);
        return n2;
    }

    public int modifyPriceOne(List<String> chkList, String price) {
        int n = productDAO.modifyPriceOne(chkList, price);
        return n;
    }

    public int insertLogOne(List<String> chkList, String price) {

        int n2 = productDAO.insertLogOne(chkList, price);
        return n2;
    }
}
