package com.zerock.b03.service;

import com.zerock.b03.dto.FriendDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
class FriendServiceImplTests {

    @Autowired
    private FriendService friendService;

    @Test
    public void register(){
        FriendDTO friendDTO = FriendDTO.builder()
                .name("정헤민")
                .phone("010-1111-2222")
                .email("혜미니")
                .address("정자동")
                .build();
        friendService.register(friendDTO);
    }

    @Test
    public void modify(){
        Long fno = 100L;
        FriendDTO friendDTO = FriendDTO.builder()
                .name("수정")
                .phone("수정")
                .email("수정")
                .address("수정")
                .build();
        friendService.modify(fno, friendDTO);
    }

    @Test
    public void read(){
        Long fno = 100L;
        FriendDTO friendDTO = friendService.read(fno);
        log.info("friendDTO ====> " + friendDTO);
    }


}