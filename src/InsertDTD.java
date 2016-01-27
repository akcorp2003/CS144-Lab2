import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class InsertDTD {
	
	private String _xml_filename;
	private String _dtd_filename;
	
	public InsertDTD(String xml_filename, String dtd_filename){
		set_xml_filename(xml_filename);
		set_dtd_filename(dtd_filename);
	}

	public String get_xml_filename() {
		return _xml_filename;
	}

	public void set_xml_filename(String _xml_filename) {
		this._xml_filename = _xml_filename;
	}

	public String get_dtd_filename() {
		return _dtd_filename;
	}

	public void set_dtd_filename(String _dtd_filename) {
		this._dtd_filename = _dtd_filename;
	}
	
	//code used from StackOverflow user McDowell
	//does not account for existing DTD document heading
	public void add_dtd()
	{
		TransformerFactory tf = TransformerFactory.newInstance();	
		try{
			Transformer transformer = tf.newTransformer();
			transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, this._dtd_filename);
			transformer.transform(new StreamSource(this._xml_filename), new StreamResult(System.out));
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
