public class RoachSim{
	public static void main(String[] args){
		RoachPop rp = new RoachPop(10);
		rp.breed();
		rp.spray(10);
		System.out.println(rp.getR());
		rp.breed();
		rp.spray(10);
		System.out.println(rp.getR());
		rp.breed();
		rp.spray(10);
		System.out.println(rp.getR());
		rp.breed();
		rp.spray(10);
		System.out.println(rp.getR());
	}
}