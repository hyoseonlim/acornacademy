package pack.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pack.dto.MemberDto;
import pack.entity.Member;
import pack.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberRepository repository;
	
	@Override
	public void getList(Model model) {
		
		/*
		방법1: 일반 메소드 사용
		
		// member 전체 자료 반환 (model에 추가하면 돼)
		List<Member> entityList = repository.findAll();
		
		List<MemberDto> list = new ArrayList<MemberDto>();
		// Entity ➡️ DTO: 변환 메소드 build() 말고 아래 방법으로🐧
		for(Member temp: entityList) {
			MemberDto dto = new MemberDto();
			dto.setNum(temp.getNum());
			dto.setName(temp.getName());
			dto.setAddr(temp.getAddr());
			list.add(dto);
		}
		// 컨트롤러에게 MemDto가 담긴 list로 전달
		model.addAttribute("list",list);
		*/
		
		// 방법2: List<Member>를 stream으로 변경해서 map()을 사용하여 List<MemberDto>로 변경하기
		List<MemberDto> list1 = repository.findAllByOrderByNumDesc()
							.stream().map(item -> MemberDto.toDto(item)).toList();
		model.addAttribute("list",list1);
		
	
		// 방법3: 람다 표현식을 메소드 참조 표현식으로 기술 (클래스명::메소드명)
		List<MemberDto> list2 = repository.findAllByOrderByNumDesc()
							.stream().map(MemberDto::toDto).toList();
	}
	
	// 수정 자료 읽기
	@Override
	public void getData(Long num, Model model) {
		Member mem = repository.findById(num).get();
		model.addAttribute("dto", MemberDto.toDto(mem));
	}
	
	@Override
	public void insert(MemberDto bean) {
		// 원래 Form Bean 씀. Entity로 바꿔줘야 함
		// JPA 작업 영역 내로 들어갈 때 일반 자료 전달용 (Dto, FormBean) 객체를 대응 엔티티로 변환
		Member member = Member.toEntity(bean);
		repository.save(member);
	}
	
	@Override
	public void update1(MemberDto bean) {
		repository.save(Member.toEntity(bean));
	}
	
	@Override
	public void update2(MemberDto bean) {

	}
	
	@Override
	public void delete(Long num) {
		Member mem = repository.findById(num).get();
		repository.delete(mem);
	}
}
