package com.example.jpa.springexamples.notice.controller;

import com.example.jpa.springexamples.notice.entity.Notice;
import com.example.jpa.springexamples.notice.model.NoticeInput;
import com.example.jpa.springexamples.notice.model.NoticeModel;
import com.example.jpa.springexamples.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ApiNoticeController {

    private final  NoticeRepository noticeRepository;

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
     *  - url 주소 : /api/notice4
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

    /*  11. 공지사항에 글을 등록하기 위해서 글작성에 대한 API를 만들어 보세요.
     *  [ 조건 ]
     *  - Rest API 형식
     *  - HTTP 메소드 : POST
     *  - url 주소 : /api/notice
     *  - 파라미터값: x-www-from-urlencoded 형식의 제목, 내용
     *    - 파라미터는 추상화하지 않고 기본 데이터 타입 형태로 전달받음
     *  - 리턴값 : 입력된 형태에 게시글ID(1)을 추가하여 모델 형태로 리턴
     */
    @PostMapping("/api/notice1")
    public NoticeModel addNotice1(@RequestParam  String title, @RequestParam String content) {

        NoticeModel notice = NoticeModel.builder()
                .id(1)
                .title(title)
                .content(content)
                .regDate(LocalDateTime.now())
                .build();

        return notice;
    }

    /*  12. 공지사항에 글을 등록하기 위해서 글작성에 대한 API를 만들어 보세요.
     *  [ 조건 ]
     *  - Rest API 형식
     *  - HTTP 메소드 : POST
     *  - url 주소 : /api/notice
     *  - 파라미터값: x-www-from-urlencoded 형식의 제목, 내용
     *    - 파라미터를 공지사항 모델로 추상화하여 전달받음
     *  - 리턴값 : 입력된 형태에 게시글ID(2)과 등록일자(현재시간) 추가하여 모델 형태로 리턴
     */
    @PostMapping("/api/notice2")
    public NoticeModel addNotice2(NoticeModel noticeModel) {

        noticeModel.setId(2);
        noticeModel.setRegDate(LocalDateTime.now());

        return noticeModel;
    }

    /*  13. 공지사항에 글을 등록하기 위해서 글작성에 대한 API를 만들어 보세요.
     *  [ 조건 ]
     *  - Rest API 형식
     *  - HTTP 메소드 : POST
     *  - url 주소 : /api/notice
     *  - 파라미터값: application/jason 형식의 제목, 내용
     *    - 파라미터를 공지사항 모델로 추상화하여 전달받음
     *  - 리턴값 : 입력된 형태에 게시글ID(3)과 등록일자(현재시간) 추가하여 모델 형태로 리턴
     */
    @PostMapping("/api/notice3")
    public NoticeModel addNotice3(@RequestBody NoticeModel noticeModel) {

        noticeModel.setId(3);
        noticeModel.setRegDate(LocalDateTime.now());

        return noticeModel;
    }


    /*  14. 공지사항에 글을 등록하기 위해서 글작성에 대한 API를 만들어 보세요.
     *  [ 조건 ]
     *  - Rest API 형식
     *  - HTTP 메소드 : POST
     *  - url 주소 : /api/notice
     *  - 파라미터값: application/jason 형식의 제목, 내용
     *  - 전달된 값을 저장하기 위한 JPA Repository와 Entity를 통해서 Database에 저장
     *  - 리턴값 : 저장된 id값이 포함된 Entity 리턴
     */
    @PostMapping("/api/notice4")
    public Notice addNotice4(@RequestBody NoticeInput noticeInput) {
        Notice notice = Notice.builder()
                .title(noticeInput.getTitle())
                .contents(noticeInput.getContent())
                .regDate(LocalDateTime.now())
                .build();

        noticeRepository.save(notice);

        return notice;
    }

    /*  15. 공지사항에 글을 등록하기 위해서 글작성에 대한 API를 만들어 보세요.
     *  [ 조건 ]
     *  - Rest API 형식
     *  - HTTP 메소드 : POST
     *  - url 주소 : /api/notice
     *  - 파라미터값: application/jason 형식의 제목, 내용
     *  - 공지사항 등록일은 현재시간을 저장, 공지사항 조회수와 좋아요 수는 초기값을 0으로 설정
     *  - 전달된 값을 저장하기 위한 JPA Repository와 Entity를 통해서 Database에 저장
     *  - 리턴값 : 저장된 id값이 포함된 Entity 리턴
     */
    @PostMapping("/api/notice")
    public Notice addNotice(@RequestBody NoticeInput noticeInput) {
        Notice notice = Notice.builder()
                .title( noticeInput.getTitle() )
                .contents( noticeInput.getContent() )
                .regDate(LocalDateTime.now())
                .hits(0)
                .likes(0)
                .build();

        Notice resultNotice = noticeRepository.save(notice);

        return resultNotice;
    }

}
