package club.xianmusic.music.service;

public interface MailService {

	void sendSimpleMail(String to, String subject, String content);
	
	String generateMade(int length);
}
