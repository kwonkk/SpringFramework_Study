package com.example.ex02.domain.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component // Spring에 등록
@Data
public class InfoDTO {
	private String name;
	private int age;
}
