package com.example.jpa.springexamples.notice.model;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class NoticeModel {

    // ID, 제목, 내용, 등록일(작성일)

    private int id;
    private String title;
    private String content;
    private LocalDateTime regDate;


}
