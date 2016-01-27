import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;

public class XMLBuilder {
	
	private String _xml_filename;
	private Document _document;
	
	public XMLBuilder(String xmlfilename){
		set_xml_filename(xmlfilename);
	}

	public String get_xml_filename() {
		return _xml_filename;
	}

	public void set_xml_filename(String _xml_filename) {
		this._xml_filename = _xml_filename;
	}
	
	public Document get_document(){
		return _document;
	}
	
	public void buildXML() {
		DocumentBuilderFactory b_factory = DocumentBuilderFactory.newInstance();
		b_factory.setValidating(true); //validate the XML document
		try {
			DocumentBuilder builder = b_factory.newDocumentBuilder();
			Document my_doc = builder.parse(new File(this.get_xml_filename()));
			_document = my_doc;
			my_doc.getDocumentElement().normalize(); //makes sure everything is kept neat and tidy
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Element get_root(){
		Element root = _document.getDocumentElement();
		return root;
	}
}
