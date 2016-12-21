
public class Main {
	public static void main(String[] args) throws Exception
	{
		run1();
		System.out.println("End of main!");
	}
	public static void run1() throws Exception
	{
		String iptPath = "data/venus_users.xml";
		String optPath = "data/venus_users.csv";
		Policeoffice po = new Policeoffice();
		po.interfaces(iptPath, optPath);
//		iptPath = "data/Hospital.xml";
//		optPath = "data/Hospital.csv";
//		po.interfaces(iptPath, optPath);
	}
}
