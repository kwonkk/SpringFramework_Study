package com.example.ex02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ex02.domain.vo.LoginDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class TaskController {
//���̵�� ��й�ȣ�� �Է¹��� �� ���̵� admin�� ��� admin.html�� �̵�
//���̵� user�� ��� user.html�� �̵�
	
//-admin.html
//-user.html
	
	@GetMapping("loginForm")
	public String GoLoginForm(LoginDTO loginDTO) {
		return "task/task01/login";
		}
	
	//�ܺο��� ���޹��� ���̵�� �н����带 �Ű������� �޴´�.
	@PostMapping("/login")
	public String login(@ModelAttribute("id")String id,String pw) {
		//���� ���̵� admin�� ���
		if(id.equals("admin")) {
			return "task/task01/admin";
		}
		//���� ���̵� admin�ƴ� ��� user.jsp�� �̵�
		return "task/task01/user";
	}
}