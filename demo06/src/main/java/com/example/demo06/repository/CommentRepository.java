package com.example.demo06.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo06.model.Comment;

public interface CommentRepository 
	extends JpaRepository<Comment, Long>{
	
	// 댓글 추가
	@Modifying
	@Query(value="insert into tbl_comment6 (content, regdate, bnum, user_id) values(?1, now(), ?2, ?3)",
	nativeQuery = true)
	public void insert(String content, Long bnum, Long user_id);
	
	// JPQL(Java Persistence Query Language, Entity 객체를 중심)
	// @Query("select sc from tbl_comment6 sc where bnum=?1") EAGER
	@Query("select sc from tbl_comment6 sc join fetch sc.board where bnum=?1") // LAZY
	public List<Comment> findByBnum(Long bnum);

}
