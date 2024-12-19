package com.hj1000.todo.DTO;

import jakarta.persistence.Column;
import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
//Builder 변수들을 DTO 만드는 작업
//ToString DTO를 변수로 출력
public class TodoDTO {

    private Integer id; // pk
    private String title;   // 제목
    private String task;    // 할 일
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date; // 날짜
    private String importance;  // 중요도
    private String status;      // 상태
    private LocalDateTime regDate;  // 생성일자
    private LocalDateTime modDate;  // 수정일자
}
