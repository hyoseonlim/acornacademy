package pack.controller;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class BoardBean { // Entity아님. Form Bean
	private int num, readcnt;
	private String author, title, content;
	private Timestamp bwrite;
	private String searchOption, searchValue; // 검색용
}
