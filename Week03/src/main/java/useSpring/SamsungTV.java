package useSpring;

public class SamsungTV implements TV{
	
	//수정1. 배화스피커 사용할 수 있도록 변수 선언
	private BaewhaSpeaker speaker;
	
	public SamsungTV() {
		System.out.println("삼성 티브 객체 생성");
	}

	public SamsungTV(BaewhaSpeaker speaker) { //수정2.
		this.speaker=speaker;
	}
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("삼성 켠다.");
	}

	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("삼성 끈다.");
	}

	public void volumeUp() {
		// TODO Auto-generated method stub
		speaker.volumeUp();
	}

	public void volumeDown() {
		// TODO Auto-generated method stub
		// System.out.println("삼성 소리 내린다.");
		speaker.volumeDown();
	}

}
