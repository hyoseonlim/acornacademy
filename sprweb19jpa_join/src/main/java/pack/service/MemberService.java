package pack.service;

import org.springframework.ui.Model;

import pack.dto.MemberDto;

public interface MemberService {
	void getList(Model model);
	void insert(MemberDto bean);
	void getData(Long num, Model model);
	void update1(MemberDto bean);
	void update2(MemberDto bean);
	void delete(Long num);
}
