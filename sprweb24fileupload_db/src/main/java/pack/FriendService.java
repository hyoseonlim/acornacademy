package pack;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendService {
	@Autowired
	private FriendRepository repository;
	
	public void saveFriend(Friend friend) {
		repository.save(friend);
	}
	
	public List<Friend> getAll(){
		// Friend를 모두 읽어 각 객체의 사진을 Base64로 변환 후, 그 결과를 리스트에 저장
		return repository.findAll()
				.stream()
				.map(this::convertToBase64) // 아래에 정의한 메소드
				.collect(Collectors.toList());
	}
	
	private Friend convertToBase64(Friend friend) {
		// Base64를 인코딩하여 사진을 DB에 저장
		if(friend.getSajin() != null && friend.getSajin().length > 0) {
			String base64Image = Base64.getEncoder().encodeToString(friend.getSajin());
			friend.setBase64Image(base64Image);
		}
		return friend;
	}
	
	// bunho 증가
	public int generateBunho() {
		Integer lastBunho = repository.findLastBunho();
		return lastBunho == null ? 1 : lastBunho+2;
	}
}
