package ocp;

public class MediaReader implements Classic {

	int version =2;
	@Override
	public void read() {
		// TODO Auto-generated method stub
		System.out.println(version);
		System.out.println(Classic.version);
	}

}
