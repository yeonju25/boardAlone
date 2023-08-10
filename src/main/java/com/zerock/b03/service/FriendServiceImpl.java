package com.zerock.b03.service;

import com.zerock.b03.domain.Friend;
import com.zerock.b03.dto.FriendDTO;
import com.zerock.b03.repository.FriendRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor // + private final == 이거랑 @Autowired 이거랑 같음
public class FriendServiceImpl implements FriendService {

    private final FriendRepository friendRepository;

    @Override
    public void register(FriendDTO friendDTO) {
        Friend friend = Friend.builder()
                .name(friendDTO.getName())
                .phone(friendDTO.getPhone())
                .email(friendDTO.getEmail())
                .address(friendDTO.getAddress())
                .build();
        friendRepository.save(friend);
    }

    @Override
    public void modify(Long fno, FriendDTO friendDTO) {
        Optional<Friend> friend = friendRepository.findById(fno);
        Friend friend1 = friend.orElseThrow();
        friend1.change(friendDTO.getPhone(), friendDTO.getEmail(), friendDTO.getAddress());
        friendRepository.save(friend1);
    }

    @Override
    public FriendDTO read(Long fno) {
        Optional<Friend> friend = friendRepository.findById(fno);
        Friend friend1 = friend.orElseThrow();
        FriendDTO friendDTO = FriendDTO.builder()
                .name(friend1.getName())
                .phone(friend1.getPhone())
                .email(friend1.getEmail())
                .address(friend1.getAddress())
                .build();
        return friendDTO;
    }

    @Override
    public List<FriendDTO> list() {
        List<Friend> list = friendRepository.findAll();
        List<FriendDTO> dtoList = list.stream()
                .map(Friend::entityToDTO)
                .collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public void remove(Long fno) {
        friendRepository.deleteById(fno);
    }
}
