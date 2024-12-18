package com.hj1000.todo.Repository;

import com.hj1000.todo.Entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoEntity,Integer> {
}
/*
JPA는 필드명으로 쿼리를 작성해서 데이터베이스 이용
.Save(): id 가 없으면 삽입, id가 존재하면 수정

.FindBy필드명 : 조회
.FindById() : 기본키에 해당하는 레코드를 조회
.FindBySubject() : 해당필드로 값을 조회해서 레코드를 조회
.FindBySubjectAndContent(제목, 내용) : 제목과 내용에 값이 존재하면 레코드를 조회
.FindBySubjectOrContent(제목, 내용) : 제목 또는 내용에 값이 존재하면 레코드를 조회

.DeleteById() : 해당 기본키의 값이 레코드를 삭제

쿼리가 복잡하면 JPA에 한계 발생, 이때 Query 문법으로 작성
*JPA쿼리 작성법(SQL+Entity)
@Query(value = "SELECT * FROM 엔티티명 WHERE 변수명 = 값", nativeQuery=True)

*데이터베이스 쿼리 작성법
@Query("SELECT 별칭 FROM 테이블명 별칭 WHERE 별칭.필드명 = 조건")

*페이징 처리
Page<엔티티> findBy필드명(변수, Pageable pageable)

*정렬 처리
List<엔티티> findBy필드명(변수, Sort sort)
*/
