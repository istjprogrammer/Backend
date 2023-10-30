package com.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.exam.domain.Board;
import com.exam.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/list")
    // 밑에 2줄 안쳐줘도 자동으로 list.jsp를 찾음
    public ModelAndView list() throws Exception{
        List<Board> list = boardService.getList();

        ModelAndView mv = new ModelAndView("board/list");
        mv.addObject("list", list);

        return mv;
    }

    @GetMapping("/write")
    public String write() {
        return "board/write";
    }

    @PostMapping("/write")
    public String write(@ModelAttribute Board board) throws Exception{
        // System.out.println(board.getbContent());
        boardService.write(board);
        return "redirect:/board/list";
    }

    @GetMapping("/read")
    public void read(@RequestParam int bNo, Model model) throws Exception{
        Board board = boardService.read(bNo);
        model.addAttribute(board);
    }

    @GetMapping("/delete")
    public String delete() {
        return null;
    }
}