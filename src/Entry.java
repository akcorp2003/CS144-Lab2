import java.io.*;

public class Entry {
	
	public static void main(String args[])
	{
		//standardize the input arguments as:
		//arg[0] the DTD document
		//arg[i] where i != 0 , XML document
		
		InsertDTD DTDinserter = new InsertDTD(args[1], args[0]);
		DTDinserter.add_dtd();
		
		XMLBuilder b_xml = new XMLBuilder(args[1]);
		b_xml.buildXML();
	}
}
