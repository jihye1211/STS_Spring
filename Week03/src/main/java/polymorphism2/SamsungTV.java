package polymorphism2;

public class SamsungTV implements TV{

	private SonySpeaker speaker;
	
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("삼성 티브 전원 켠다.");
	}

	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("삼성 티브 전원 끈다.");
	}

	public void volumeUp() {
		speaker = new SonySpeaker();
		speaker.volumeUp();
		// TODO Auto-generated method stub
		//System.out.println("삼성 티브 소리 높힌다.");
	}

	public void volumeDown() {
		speaker = new SonySpeaker();
		speaker.volumeDown();
		// TODO Auto-generated method stub
		//System.out.println("삼성 티브 소리 내린다.");
	}



}
