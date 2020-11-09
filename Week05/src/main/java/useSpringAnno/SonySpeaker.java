package useSpringAnno;

import org.springframework.stereotype.Component;

@Component("sony")
public class SonySpeaker implements Speaker{
	public SonySpeaker() {
		System.out.println("소니스피커 객체 생성");
	}

	public void volumeUp() {
		System.out.println("소니스피커 소리 올린다.");
	}
	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println("소니스피커 소리 내린다.");
	}
}
