package useSpring;

public class BaewhaSpeaker implements Speaker{
	
	//1. 생성자
	//2. volumeUp 메서드
	//3. volumeDown 메서드
	
	public BaewhaSpeaker() {
		System.out.println("배화스피커 객체 생성");
	}
	public void volumeUp() {
		System.out.println("배화스피커 소리 올린다.");
	}
	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println("배화스피커 소리 내린다.");
	}
}
