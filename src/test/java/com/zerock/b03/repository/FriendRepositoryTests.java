package com.zerock.b03.repository;

import com.zerock.b03.domain.Friend;
import com.zerock.b03.dto.FriendDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
class FriendRepositoryTests {

    @Autowired
    private FriendRepository friendRepository;

    @Test
    public void testInsert(){
        IntStream.rangeClosed(1,20).forEach(i ->{
                    Friend friend = Friend.builder()
                            .name("이름" + i)
                            .phone("전화번호" + i)
                            .email("이메일" + i)
                            .address("주소" + i)
                            .build();
                    friendRepository.save(friend);
                });
    }

    @Test
    public void testSelect(){
        Long fno = 10L;
        Optional<Friend> friend = friendRepository.findById(fno);
        log.info("Friend ===>" + friend);
    }

    @Test
    public void testModify(){
        Long fno = 1L;
        Optional<Friend> friend = friendRepository.findById(fno);
//        friend.get().change("수정함", "수정함", "수정함");
//        Friend friend1 = friend.get();
        Friend friend1 = friend.orElseThrow();
        friend1.change("수정함", "수정함", "수정함");
        friendRepository.save(friend1);
        log.info("Friend ===>" + friend1);
    }

    @Test
    public void testDelete(){
        Long fno = 100L;
        friendRepository.deleteById(fno);
    }


}