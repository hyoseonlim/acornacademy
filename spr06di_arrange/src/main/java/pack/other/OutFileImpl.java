package pack.other;

import java.io.FileWriter;

public class OutFileImpl implements OutFileInter {
	private String filePath; // 출력 파일 경로
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	@Override
	public void outFile(String msg) {
		// 메시지를 파일로 출력
		try {
			FileWriter fw = new FileWriter(filePath);
			fw.write(msg);
			fw.close();
			System.out.println("파일 저장 완료 (●'◡'●)");
		} catch (Exception e) {
			System.out.println("outFile err: " + e);
		}
	}
}
