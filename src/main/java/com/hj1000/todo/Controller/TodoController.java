package com.hj1000.todo.Controller;

import com.hj1000.todo.DTO.TodoDTO;
import com.hj1000.todo.Service.TodoService;
import com.hj1000.todo.Util.PaginationUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@Log4j2
@RequiredArgsConstructor
//시작페이지(메인페이지)를 작업할 컨트롤러
public class TodoController {
    //컨트롤러는 서비스에 작업지시
    private final TodoService todoService;

    /*-------------------------------------------------------------
    함수명 : String listGet(Pageable pageable, Model model)
    맵핑 : get(/list)
    인수 : 데이터를 조회할 페이지 번호
    결과 : list 페이지
    설명 : 페이지번호를 받아서 해당페이지의 데이터를 조회해서 목록페이지로 전달
    -------------------------------------------------------------*/

    //페이지번호가 생략되었을 때 기본 1페이지로 설정
    @GetMapping("/list")
    public String listGet(@PageableDefault(page = 1)Pageable pageable , Model model){
        Page<TodoDTO> todoDTOS = todoService.list(pageable);
        Map<String, Integer> pageInfo = PaginationUtil.Pagination(todoDTOS);
        model.addAttribute("list",todoDTOS);
        model.addAllAttributes(pageInfo);

        return "list";
    }

     /*-------------------------------------------------------------
    함수명 : String insertGet()
    맵핑 : get(/insert)
    인수 : 데이터를 조회할 페이지 번호
    결과 : insert 페이지
    설명 : 페이지번호를 받아서 해당페이지의 데이터를 조회해서 목록페이지로 전달
    -------------------------------------------------------------*/


    @GetMapping("/insert")
    public String insertGet(){
        return "insert";

    }
     /*-------------------------------------------------------------
    함수명 : String insertPost(TodoDTO todoDTO)
    맵핑 : post(/insert)
    인수 : 입력폼에 데이터
    결과 : 없음
    설명 : 입력폼에 입력한 데이터를 서비스를 통해 데이터베이스 저장
    -------------------------------------------------------------*/
    @PostMapping("/insert")
    public String insertPost(TodoDTO todoDTO){
        // 서비스를 통해서 저장을 한다.
        log.info("컨트롤러로 들어온 todoDTO" + todoDTO);
        todoService.insert(todoDTO);

        return "redirect:/list";
    }
     /*-------------------------------------------------------------
    함수명 : String updateGet(Integer id, Midel model)
    맵핑 : get(/update)
    인수 : 데이터를 조회할 페이지 번호
    결과 : update 페이지
    설명 : 해당 id로 서비스에서 데이터를 조회한 결과를 수정폼 페이지로 전달
    -------------------------------------------------------------*/

    @GetMapping("/update")
    public String updateGet(Integer id, Model model){
        log.info("뷰에서 찾아온 글 번호" + id);
        // 서비스를 통해서 해당 레코드를 조회
        TodoDTO todoDTO = todoService.read(id);
        model.addAttribute("data" , todoDTO);
        return "update";

    }

     /*-------------------------------------------------------------
    함수명 : String updatePost(TodoDTO todoDTO)
    맵핑 : post(/update)
    인수 : 수정폼에 데이터
    결과 : 없음
    설명 : 입력폼에 입력한 데이터를 서비스를 통해 데이터베이스 저장
    -------------------------------------------------------------*/
    @PostMapping("/update")
    public String updatePost(TodoDTO todoDTO){
        //서비스를 통해서 수정처리
        todoService.update(todoDTO);

        return "redirect:/list";
    }
    /*-------------------------------------------------------------
    함수명 : String deleteGet(Integer id)
    맵핑 : get(/delete)
    인수 : 기본키 일련번호
    결과 : 없음
    설명 : 해당 id로 서비스에서 데이터를 조회해서 삭제
    -------------------------------------------------------------*/

    @GetMapping("/delete")
    public String deleteGet(@RequestParam Integer id){
        // 서비스를 통해 데이터 삭제
        todoService.delete(id);

        return "redirect:/list";
    }

}
