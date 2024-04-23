package com.example.jpa.springexamples.notice.controller;

import com.example.jpa.springexamples.notice.model.NoticeModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiNoticeController {


    /*  6. 공지사항 게시판의 목록에 대한 요청을 처리하는 API
     *  [ 조건 ]
     *  - Rest API 형식
     *  - HTTP 메소드 : GET
     *  - url 주소 : /api/notice1
     *  - 리턴값 : 공지사항입니다.
     */
    @GetMapping("/api/notice1")
    public String noticeOne() {

        return "공지사항입니다.";
    }

    /*  7. 공지사항 게시판의 목록에 대한 요청을 처리하는 API
     *  [ 조건 ]
     *  - Rest API 형식
     *  - HTTP 메소드 : GET
     *  - url 주소 : /api/notice2
     *  - 리턴값 : 게시판의 내용을 추상화한 모델(게시글 ID, 제목, 내용, 등록일)
     *    - 예시 : 게시글ID = 1, 제목 = 공지사항입니다, 내용 = 공지사항 내용입니다, 등록일 = 2024-04-23
     */
    @GetMapping("/api/notice2")
    public NoticeModel noticeTwo() {

        NoticeModel notice = new NoticeModel();
        notice.setId(1);
        notice.setTitle("공지사항입니다");
        notice.setContent("공지사항내용입니다");
        notice.setRegDate(LocalDateTime.of(2024, 4, 23, 0 , 0));

        return notice;
    }

    /*  8. 공지사항 게시판의 목록에 대한 요청을 처리하는 API
     *  [ 조건 ]
     *  - Rest API 형식
     *  - HTTP 메소드 : GET
     *  - url 주소 : /api/notice3
     *  - 리턴값 : 게시판의 내용을 추상화한 모델(게시글 ID, 제목, 내용, 등록일)의 복수형태의 데이터
     *    - 예시 : 게시글ID = 1, 제목 = 공지사항입니다, 내용 = 공지사항 내용입니다, 등록일 = 2024-04-23
     */
    @GetMapping("/api/notice3")
    public List<NoticeModel> notice3() {

        List<NoticeModel> noticeModelList = new ArrayList<>();

        NoticeModel notice1 = new NoticeModel();
        notice1.setId(1);
        notice1.setTitle("공지사항입니다");
        notice1.setContent("공지사항내용입니다");
        notice1.setRegDate(LocalDateTime.of(2021, 1, 30, 0 ,0));

        noticeModelList.add(notice1);


        //NoticeModel notice2 = new NoticeModel(2, "두번째 공지사항입니다", "두번째 내용입니다", LocalDateTime.of(2024, 4, 23, 0, 0));
        //noticeModelList.add(notice2);

        noticeModelList.add(NoticeModel.builder()
                .id(2)
                .title("두번째 공지사항입니다")
                .content("두번째 내용입니다.")
                .regDate(LocalDateTime.of(2024, 4, 23, 0,0))
                .build()
        );

        return noticeModelList;
    }

    /*  9. 공지사항 게시판의 목록에 대한 요청을 처리하는 API
     *  [ 조건 ]
     *  - Rest API 형식
     *  - HTTP 메소드 : GET
     *  - url 주소 : /api/notice
     *  - 리턴값 : 게시판의 내용을 추상화한 모델(게시글 ID, 제목, 내용, 등록일)의 복수형태의 데이터
     *  - 요청한 내용이 없는 빈 목록을 리턴
     */
    @GetMapping("/api/notice")
    public List<NoticeModel> notice() {

        List<NoticeModel> noticeList = new ArrayList<>();

        return noticeList;
    }

    /*  10. 공지사항 게시판의 목록 중 전체 개수 정보에 대한 요청을 처리하는 API
     *  [ 조건 ]
     *  - Rest API 형식
     *  - HTTP 메소드 : GET
     *  - url 주소 : /api/notice/count
     *  - 리턴값 : 게시판의  게시글 개수(정수)
     *  - 컨트롤러에서 정수형을 리턴하더라고 클라이언트에서 내려가는 부분은 문자열임을 확인
     */
    @GetMapping("/api/notice/count")
    public int noticeCount() {

        return 10;
    }
}
