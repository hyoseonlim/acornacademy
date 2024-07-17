package pack.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormBean {
	private String searchValue; // 검색용
	private String code, sang, su, dan; // 추가, 수정 시 필요
}
