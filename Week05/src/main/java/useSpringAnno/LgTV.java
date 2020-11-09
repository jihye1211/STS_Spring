package useSpringAnno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv1")
public class LgTV implements TV{
	@Autowired
	@Qualifier("baewha")
	private Speaker speaker;
	private int price;
	public LgTV() {
		System.out.println("LGTV객체 생성");
	}
	
	public void setSpeaker(Speaker speaker) {
		 this.speaker=speaker;
	}
	public void setPrice(int price) {
		this.price=price;
	}
	
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("엘지 켠다.(가격):"+price);
	}

	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("엘지 끈다.");
	}

	public void volumeUp() {
		// TODO Auto-generated method stub
		/*System.out.println("엘지 소리 올린다.");*/
		speaker.volumeUp();
	}

	public void volumeDown() {
		// TODO Auto-generated method stub
		speaker.volumeDown();
	}


}
