package io.sejong.study.springbulletinboard.sample.repository;

import io.sejong.study.springbulletinboard.sample.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {


  @Query(value = "select * from board order by board_id limit :start, :size",
           nativeQuery=true)
  List<Board> findSomeCase(@Param("start") Integer start, @Param("size") Integer size);

  @Query(value = "select count(*) from board", nativeQuery = true)
  List<Integer> findpaging();

//  List<Board> findAll()
  Board findByBoardId(Long boardId);

}
