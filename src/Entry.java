import java.io.*;

import org.w3c.dom.*;

public class Entry {
	
	public static void main(String args[])
	{
		//standardize the input arguments as:
		//arg[0] the DTD document
		//arg[i] where i != 0 , XML document
		
		/*InsertDTD DTDinserter = new InsertDTD(args[1], args[0]);
		DTDinserter.add_dtd();*/
		
		XMLBuilder b_xml = new XMLBuilder(args[1]);
		b_xml.buildXML();
		
		//testing
		System.out.println(b_xml.get_root().getNodeName());
		
		Document xml_doc = b_xml.get_document();
		NodeList nList = xml_doc.getElementsByTagName("Item");
		System.out.println("============================");
		 
		for (int i = 0; i < nList.getLength(); i++)
		{
		 Node node = nList.item(i);
		 System.out.println("");    //Just a separator
		 if (node.getNodeType() == Node.ELEMENT_NODE)
		 {
		    //Print each employee's detail
		    Element eElement = (Element) node;
		    System.out.println("Name : "    + eElement.getElementsByTagName("Name").item(0).getTextContent());
		    System.out.println("Category : "  + eElement.getElementsByTagName("Category").item(0).getTextContent());
		    System.out.println("Bids : "   + eElement.getElementsByTagName("Bids").item(0).getTextContent());
		    System.out.println("Location : "    + eElement.getElementsByTagName("Location").item(0).getTextContent());
		 }
		}
	}
}
