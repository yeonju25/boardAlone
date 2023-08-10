package com.zerock.b03.dto;

import com.zerock.b03.domain.Friend;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
public class FriendDTO {

    private Long fno;

    private String name;

    private String phone;

    private String email;

    private String address;

//    private LocalDateTime redDate;
//    private LocalDateTime modDate;
}
