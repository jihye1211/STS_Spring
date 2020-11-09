package useSpring;

public class SamsungTV implements TV{
		
		//수정1. 배화스피커 사용할 수 있도록 변수 선언
		private Speaker speaker;
		private int price;
		
		
		//기본 default 생성자. SamsungTV() 괄호안에 인자가 없음=기본 생성자
		//***매개인자가 있는 생성자를 사용하기 위해서는 기본 생성자가 반드시 필요함.
		public SamsungTV() {
			System.out.println("삼성 티브 객체 생성1");
		}
		//매개인자가 있는 생성자1
		public SamsungTV(Speaker speaker) {
			System.out.println("삼성 티브 객체 생성2");
			this.speaker = speaker;
		}
		//매개인자가 있는 생성자2
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


