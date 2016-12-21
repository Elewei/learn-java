import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class BasicInfo
{
	String name;
	String character;
	String address;
	List<String> listOfPhone;
	String lat;
	String lon;
	public BasicInfo()
	{//¹¹Ôìº¯Êý?
		listOfPhone = new ArrayList<String>();
	}
}
public class Policeoffice {
	
	private void read(String iptPath, String optPath) throws Exception
	{
		InputStreamReader isr = new InputStreamReader(new FileInputStream(iptPath), "utf-8");
		BufferedReader br = new BufferedReader(isr);
		FileWriter fw = new FileWriter(optPath);
		fw.append("Name,character,address,phone,lat,lon\r\n");
		fw.flush();
		String temp;
		while((temp=br.readLine())!=null)
		{
			BasicInfo bi = new BasicInfo();
			temp = temp.trim();
			if(temp.startsWith("<Name>"))
				bi.name = temp.substring(6).replace("</Name>", "");
			while((temp=br.readLine())!=null)
			{
				temp = temp.trim();
				if(temp.startsWith("<Name>"))
				{
					bi.name = temp.substring(6).replace("</Name>", "");
				}
				else if(temp.startsWith("<character>"))
					bi.character = temp.substring(11).replace("</character>", "");
				else if(temp.startsWith("<address>"))
					bi.address = temp.substring(9).replace("</address>", "");
				else if(temp.startsWith("<phone>"))
					bi.listOfPhone.add( temp.substring(7).replace("</phone>", "") );
				else if(temp.startsWith("<lat>"))
					bi.lat = temp.substring(5).replace("</lat>", "");
				else if(temp.startsWith("<lon>"))
				{
					bi.lon = temp.substring(5).replace("</lon>", "");
					break;
				}
			}
			if(bi.name!=null)
			{
				fw.append(bi.name+","+bi.character+","+bi.address+","+(bi.listOfPhone.isEmpty()?"-":bi.listOfPhone.get(0))+","
						+bi.lat+","+bi.lon+"\r\n");
				fw.flush();
			}
		}
		br.close();
		fw.close();
	}
	public void interfaces(String iptPath, String optPath) throws Exception
	{
		read(iptPath, optPath);
	}
//	private void prt(String string)
//	{
//		System.out.print(string);
//	}
}