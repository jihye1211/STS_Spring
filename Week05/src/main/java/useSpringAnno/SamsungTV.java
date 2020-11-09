package useSpringAnno;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component("tv")
public class SamsungTV implements TV{
		@Resource(name="apple")
		//수정1. 배화스피커 사용할 수 있도록 변수 선언
		private Speaker speaker;
		private int price;
		
		public SamsungTV() {
			System.out.println("삼성 티브 객체 생성1");
		}
		
		public SamsungTV(Speaker speaker) {
			System.out.println("삼성 티브 객체 생성2");
			this.speaker = speaker;
		}
		
		public SamsungTV(Speaker speaker, int price) {
			System.out.println("삼성 티브 객체 생성3");
			this.speaker=speaker;
			this.price=price;
			
		}
		public void powerOn() {
			// TODO Auto-generated method stub
			System.out.println("삼성 켠다.(가격:"+price+")");
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


