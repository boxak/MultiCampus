package vo;

import org.springframework.web.multipart.MultipartFile;

public class FileVO {
	private MultipartFile uploadFile;
	//여러 파일 받고 싶으면 MultipartFile 객체 배열로 멤버를 선언해주면 된다.
	public MultipartFile getUploadFile() {		
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
}
