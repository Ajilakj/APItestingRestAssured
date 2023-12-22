
public class TrafficIdia implements TrafficRule{

	public static void main(String[] args) {
		TrafficIdia TrafficIdiaOBJ= new TrafficIdia();
		TrafficIdiaOBJ.GreenGo();
		TrafficIdiaOBJ.RedStop();
		TrafficIdiaOBJ.yellowWait();
	}

	@Override
	public void GreenGo() {
		System.out.println("inside Green Go");
	}

	@Override
	public void RedStop() {
		System.out.println("inside Red Stop");
	}

	@Override
	public void yellowWait() {
		System.out.println("inside yellow wait");
	}

}
