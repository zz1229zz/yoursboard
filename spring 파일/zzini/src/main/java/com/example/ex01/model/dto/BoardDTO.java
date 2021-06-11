package com.example.ex01.model.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BoardDTO {
	private int index;
	private String id;
	private String title;
	private String content;
	private Date date;
	private int startindex;
	private int cntperpage;
	private int curPage;
}
