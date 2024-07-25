package pack.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jakarta.transaction.Transactional;
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
	
	@Transactional // 이게 있어야 commit됨
	@Override
	public void update2(MemberDto bean) {
		// 🌟 1차 캐시로 인한 동일 객체 인스턴스 반환 확인 🌟 (동일한 요청에 대해서는 최초 요청으로 얻어서 저장해둔 정보를 사용)
		// https://cafe.daum.net/flowlife/HrhB/91
		// 수정할 회원의 번호를 이용해서 회원 정보 entity 객체 얻어내기
	    Member m1 = repository.findById(bean.getNum()).get();
	    Member m2 = repository.findById(bean.getNum()).get();
	    
	    // 동일성 검사
	    boolean isEqual = m1 == m2;
	    System.out.println("m1과 m2가 같냐? " + isEqual);
	    
	    // setter 메소드를 이용해서 이름과 주소 수정하기 (JPARepository의 save메소드 대신)
	    m1.setName(bean.getName());
	    m1.setAddr(bean.getAddr());
	}
	
	@Override
	public void delete(Long num) {
		Member mem = repository.findById(num).get();
		repository.delete(mem);
	}
}
