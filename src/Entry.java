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
		NodeList auctionList = xml_doc.getElementsByTagName("Item");
		System.out.println("============================");
		 
		for (int i = 0; i < auctionList.getLength(); i++)
		{
		 Node node = auctionList.item(i);
		 System.out.println("");    //Just a separator
		 if (node.getNodeType() == Node.ELEMENT_NODE)
		 {
		    //Print each employee's detail
		    Element item = (Element) node;
		    System.out.println("Name : "    + item.getElementsByTagName("Name").item(0).getTextContent());
		    System.out.println("Category : "  + item.getElementsByTagName("Category").item(0).getTextContent());
		    //System.out.println("Bids : "   + eElement.getElementsByTagName("Bids").item(0).getTextContent());
		    NodeList bidList = item.getElementsByTagName("Bid");
		    for(int j = 0; j < bidList.getLength(); j++)
		    {
		    	NodeList bidderList = item.getElementsByTagName("Bidder");
		    	for(int k = 0; k < bidderList.getLength(); k++){
		    		Element bidder = (Element) bidderList.item(k);
		    		System.out.println("Rating: " + bidder.getAttribute("Rating"));
		    		System.out.println("UserID: " + bidder.getAttribute("UserID"));
		    		//System.out.println("Location: " + item.getElementsByTagName("Location").item(0).getTextContent());
		    		NodeList locations = item.getElementsByTagName("Location");
				    for(i = 0; i < locations.getLength(); i++)
				    {
				    	Element loc = (Element) locations.item(i);
				    	if(!loc.hasAttributes()){
				    		System.out.println("Location: " + loc.getTextContent());
				    	}
				    }
		    		System.out.println("Country: " + item.getElementsByTagName("Country").item(0).getTextContent());
		    		System.out.println("Time: " + item.getElementsByTagName("Time").item(0).getTextContent());
		    		System.out.println("Amount: " + item.getElementsByTagName("Amount").item(0).getTextContent());
		    	}
		    	if(bidderList.getLength() == 0)
		    	{
		    		System.out.println("Bids: NULL");
		    	}
		    }
		    
		    //System.out.println("Location : "    + item.getElementsByTagName("Location").item(0).getTextContent());
		    NodeList locations = item.getElementsByTagName("Location");
		    for(i = 0; i < locations.getLength(); i++)
		    {
		    	Element loc = (Element) locations.item(i);
		    	if(loc.hasAttributes()){
		    		System.out.println("Location: " + loc.getTextContent());
		    		System.out.println("Latitude: " + loc.getAttribute("Latitude"));
		    		System.out.println("Longitude: " + loc.getAttribute("Longitude"));
		    	}
		    }
		 }
		}
	}
}
