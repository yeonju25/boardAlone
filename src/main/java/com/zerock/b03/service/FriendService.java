package com.zerock.b03.service;

import com.zerock.b03.dto.FriendDTO;
import org.springframework.ui.Model;

import java.util.List;

public interface FriendService {
    void register(FriendDTO friendDTO);

    void modify(Long fno, FriendDTO friendDTO);

    FriendDTO read(Long fno);

    List<FriendDTO> list();

    void remove(Long fno);

}
