package com.zerock.b03.controller;

import com.zerock.b03.dto.FriendDTO;
import com.zerock.b03.service.FriendService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/friend")
@Log4j2
public class FriendController {

    @Autowired
    private FriendService friendService;

    @GetMapping("/list")
    public void list(Model model){
        List<FriendDTO> dtoList = friendService.list();
        model.addAttribute("list", dtoList);
    }

    @GetMapping("/modify")
    public void modify(Long fno, Model model){
        FriendDTO dto = friendService.read(fno);
        model.addAttribute("dto", dto);
    }

    @PostMapping("/modify")
    public String modify(FriendDTO friendDTO){
        log.info("dto =========>" + friendDTO);
//        friendService.modify(friendDTO.getFno(), friendDTO);
        return "redirect:/friend/list";
    }

    @GetMapping("/register")
    public void register(){

    }

    @PostMapping("/register")
    public String register(FriendDTO friendDTO){
        friendService.register(friendDTO);
        log.info("friendDTO =====> " + friendDTO);
        return "redirect:/friend/list";
    }
// input에 작성한 값을 FriendDTO로 자동 바인딩받으려고 하니까 처음에 안됨
// FriendDTO클래스에 Builder만 있으면 되는줄 알았는데 아님, Setter 추가하니까 그제서야 됨

    @GetMapping("/remove")
    public String remove(Long fno){
        friendService.remove(fno);
        return "redirect:/friend/list";
    }

}
