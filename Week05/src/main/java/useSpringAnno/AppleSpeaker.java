package useSpringAnno;

import org.springframework.stereotype.Component;

@Component("apple")
public class AppleSpeaker implements Speaker {

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		System.out.println("Apple스피커 소리 높힌다.");
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println("Apple스피커 소리 내린다.");
	}

	
}
