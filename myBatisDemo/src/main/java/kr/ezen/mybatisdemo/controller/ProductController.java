package kr.ezen.mybatisdemo.controller;

import kr.ezen.mybatisdemo.service.ProductService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
//@Log4j
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/product")
    public String product(Model m) {
        // data 만들기
      /*  List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();

        map.put("pno", "1");
        map.put("pname", "텔레비전");
        map.put("kind", "가전");
        map.put("price", "300,000");
        map.put("inDate", "2022-10-10");
        map.put("upDate", "2022-10-11");
        list.add(map);

        map = new HashMap<>();
        map.put("pno", "2");
        map.put("pname", "파이선");
        map.put("kind", "도서");
        map.put("price", "30,000");
        map.put("inDate", "2022-10-13");
        map.put("upDate", "2022-10-13");
        list.add(map);*/

        List<Map<String, Object>> list = productService.getList();
        m.addAttribute("list", list);

        return "/product/product";
    }
    @GetMapping("/product/prodDel")
    public String prodDel(@RequestParam("pno") String pno){
       /*리퀘스트파람으로 뷰에서 넘긴 pno받기*/
       //로그를 찍으려면 컨트롤러에서 log4j 불러오기
        //log.info("pno : " +pno);
        int n = productService.prodDel(pno);

        return "redirect:/product";
    }

    @GetMapping("/product/prodModify")
    public String prodModify(@RequestParam("pno") String pno, Model m){
        /*리퀘스트파람으로 뷰에서 넘긴 pno받기*/
        //로그를 찍으려면 컨트롤러에서 log4j 불러오기
        //log.info("pno : " +pno);
        //int n = productService.prodModify(pno);
        Map<String, Object> map = productService.getListOne(pno);
        m.addAttribute("map", map);
        return "/product/prodModify";
    }

    @PostMapping("/product/prodModify")
    public String prodModifyPost(@RequestParam("pno") String pno,
                                 @RequestParam("pname") String pname,
                                 @RequestParam("kind") String kind,
                                 @RequestParam("price") String price){

        int n = productService.prodModify(pno, pname, kind, price);
        return "redirect:/product";
    }

    @GetMapping("/product/prodRegister")
    public String prodRegister(){
        return "/product/prodRegister";
    }

    @PostMapping("/product/prodRegister")
    public String prodRegister( @RequestParam("pname") String pname,
                                @RequestParam("kind") String kind,
                                @RequestParam("price") String price){

        int n = productService.prodRegister(pname, kind, price);
        return "redirect:/product";
    }

    @PostMapping("/product/search")
    public String prodSearch(@RequestParam(value="pname", defaultValue = "all") String pname,
                             @RequestParam("kind") String kind, Model model){
        System.out.println("pname = " + pname);
        System.out.println("kind = " + kind);
        List<Map<String, Object>> list = productService.prodSearch(pname, kind);
        model.addAttribute("list", list);
        System.out.println("list = " + list);
        // 검색할 때 입력값 안넣고 버튼 누르면 null값이 넘어옴. 따라서 default값을 requestparam에서 정해줌

        return "/product/product";
    }

    // 선택삭제
    @PostMapping("/product/prodsDelete")
    public String prodsDelete(@RequestParam("chkPno") List<String> chkList){
        if (chkList != null){
            int n = productService.prodsDelete(chkList);
        }
        return "redirect:/product";
    }

    // 선택수정
    @PostMapping("/product/prodsModify")
    public String prodsModify(@RequestParam("chkPno") List<String> chkList,
                              @RequestParam("zzena") String price){
        if (chkList != null){
          /*  for (String pno : chkList){
               int n = productService.modifyPrice(pno, price);
               // 로그 남기기
               int n2 = productService.insertLog(pno, price); }*/


               // 이렇게 하면 서버에 너무 자주 왔다갔다 함. 동적쿼리써서 서버통신 횟수 줄이기
            int n = productService.modifyPriceOne(chkList, price);
            int n2 = productService.insertLogOne(chkList, price);
        }

        return "redirect:/product";
    }
}
