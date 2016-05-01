package xml_util;

//import it.oneans.common.utility.NodeUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.List;

import javax.xml.transform.TransformerException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.Text;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

//import com.sun.org.apache.xpath.internal.XPathAPI;

public class XMLDom4jUtility {

    /**
     * 
     * Metodo che parsa il file xml 
     * 
     * @param url - Oggetto File del file xml da parsare
     * @return
     * @throws DocumentException
     */
    public static Document parseFile(File url) throws DocumentException {

        SAXReader reader = new SAXReader();
        Document document = reader.read(url);
        return document;
    }

//    /**
//     * Scrive il Document xml in una stringa
//     * 
//     * @param doc
//     * @return
//     * @throws Exception
//     */
//    public static String writeDocumentToString(Document doc) throws Exception {
//        /*
//         ByteArrayOutputStream baos = new ByteArrayOutputStream();
//         XMLWriter write = new XMLWriter(baos);
//         write.write(doc);
//         
//         return baos.toString();
//         */
//        return doc.asXML();
//    }
//
//    public static String writeDocumentToString(Node doc) throws Exception {
//        /*
//         ByteArrayOutputStream baos = new ByteArrayOutputStream();
//         XMLWriter write = new XMLWriter(baos);
//         write.write(doc);
//         
//         return baos.toString();
//         */
//        return doc.asXML();
//    }
//
//    /**
//     * Scrive su file un documento xml
//     * 
//     * @param doc
//     * @param file
//     * @throws FileNotFoundException
//     * @throws IOException
//     * @throws UnsupportedEncodingException
//     */
//    public static void writeDocumentToFile(Document doc, File file) throws FileNotFoundException, IOException, UnsupportedEncodingException {
//        OutputStream os = new FileOutputStream(file);
//        XMLWriter write = new XMLWriter(os);
//        write.write(doc);
//        write.close();
//    }
//
//    /**
//     * 
//     * Metodo che parsa il file xml
//     * 
//     * @param url - URL del file xml da parsare
//     * @return
//     * @throws DocumentException
//     */
//    public static Document parseUrl(URL url) throws DocumentException {
//
//        SAXReader reader = new SAXReader();
//        Document document = reader.read(url);
//        return document;
//    }
//
//    /**
//     * 
//     * Metodo che parsa il file xml
//     * 
//     * @param url - InptSream del file xml da parsare
//     * @return
//     * @throws DocumentException
//     */
//    public static Document parseInputStream(InputStream url) throws DocumentException {
//
//        SAXReader reader = new SAXReader();
//        Document document = reader.read(url);
//        return document;
//    }

    /**
     * Metodo che parsa il file xml
     * 
     * @param url - String che rappresenta il path del resource 
     * @return
     * @throws DocumentException
     * @throws FileNotFoundException 
     */
    public static Document parseFile(String url) throws DocumentException, FileNotFoundException {

        InputStream inStream = XMLDom4jUtility.class.getClassLoader().getResourceAsStream(url);

        if(inStream ==null) {
        	inStream = new FileInputStream(url);
 
        }
        
        SAXReader reader = new SAXReader();
        Document document = reader.read(inStream);

        return document;
    }
    
   
    /**
     * Metodo che parsa il file xml
     * 
     * @param xml - String che contiene un documento xml 
     * @return
     * @throws DocumentException
     */
    public static Document parseString(String xml) throws DocumentException {

        Document document = DocumentHelper.parseText(xml);

        return document;
    }

//    /**
//     * Ritorno l'element root del xml passato
//     * 
//     * @param xml
//     * @return
//     * @throws DocumentException
//     */
//    public static Element parseStringToElement(String xml) throws DocumentException {
//        Element result = null;
//
//        if (xml == null || (xml != null && xml.equals(""))) {
//
//            return null;
//        }
//
//        result = parseString(xml).getRootElement();
//
//        return result;
//    }
//
//    /**
//     * Data una string xml mi ritorna un'oggetto DOM.
//     * 
//     * @param xml
//     * @return
//     * @throws DocumentException
//     */
//    public static Node parseStringToNode(String xml) throws DocumentException {
//        Node result = null;
//
//        if (xml == null || (xml != null && xml.equals(""))) {
//
//            return null;
//        }
//
//        try {
//            result = parseString(xml).getRootElement();
//
//        } catch (Exception e) {
//
//            Text testo = DocumentHelper.createText(xml);
//            result = testo;
//        }
//
//        return result;
//    }
//
//    /**
//     * Aggiungo un nodo figlio ad un'altro nodo
//     * 
//     * @param parent
//     * @param child
//     */
//    public static void addNode(Node parent, Node child) {
//
//        if (parent == null || child == null) {
//            return;
//        }
//
//        Element parElemnt = parent.getParent().getParent();
//        parElemnt.add(child);
//
//    }
//
//    /**
//     * Metodo che restituisce un valore di un tag
//     * se il tag non esiste ritorna null
//     * 
//     * @param document
//     * @param xPath
//     * @return
//     * @throws Exception
//     */
//    public static String getSingleValue(Document document, String xPath) throws Exception {
//
//        String res = null;
//
//        Node node = document.selectSingleNode(xPath);
//
//        if (node != null)
//            res = node.getStringValue();
//
//        return res;
//
//    }
//    
//    public static String setSingleValue(Document document, String xPath, String value) throws Exception {
//    	
//        Node node = document.selectSingleNode(xPath);
//        
//        if (node != null)
//           node.setText(value);
//        return writeDocumentToString(document);
//    }
//    
//    public static String getNodeValue(String xmlData, String xPath) {
//		try {
//			org.w3c.dom.Node node = XPathAPI.selectSingleNode(NodeUtil.getNode(xmlData), "//" + xPath);
//			return node.getTextContent();
//		} catch (TransformerException e) {
//			return  "";
//		} catch (Exception e) {			
//			return  "";
//		}
//	}
//    
//    
//
//    /**
//     * Dato un xpath restituisce il nodo padre di quello agganciato
//     * con l'xpath inserito, il tutto sull'oggetto docuement passato come parametro.
//     * 
//     * @param doc
//     * @param xpath
//     * @return - il nome dell'handler associato al tag bean passato come param
//     * @throws Exception
//     */
//    public static String getParentTag(Document doc, String xpath) throws Exception {
//
//        Node nodo = doc.selectSingleNode(xpath);
//
//        Element elem = nodo.getParent();
//
//        Node nodoHand = elem.selectSingleNode("@name");
//
//        String nomeHand = nodoHand.getStringValue();
//
//        return nomeHand;
//
//    }
//
//    /**
//     * Ritorno l'elenco dei nodi dato un xPath
//     * 
//     * @param doc
//     * @param xPath
//     * @return
//     * @throws Exception
//     */
//    public static List<Node> getNodeList(Document doc, String xPath) throws Exception {
//
//        return doc.selectNodes(xPath);
//
//    }
//
//    /**
//     * Ritorna il valore restituito dal xPath passato sia esso il valore di un attributo o del nodo stesso
//     * 
//     * @param nod
//     * @param xPath
//     * @return
//     * @throws Exception
//     */
//    public static String getNodeValue(Node nod, String xPath) throws Exception {
//        return nod.valueOf(xPath);
//    }
//
//    /**
//     * Ritorna il valore del nodo passato
//     * 
//     * @param nod
//     * @return
//     * @throws Exception
//     */
//    public static String getContentNodeValue(Node nod) throws Exception {
//        return nod.getStringValue();
//    }
//
//    /**
//     * Ritorno il singolo nodo dato un xPath
//     * 
//     * @param doc
//     * @param xPath
//     * @return
//     * @throws Exception
//     */
//    public static Node getSingleNode(Document doc, String xPath) throws Exception {
//        return doc.selectSingleNode(xPath);
//    }
//
//    /**
//     * Restituisce l'elenco degli element di quel nodo che soddisfa l'xPath passato
//     * 
//     * @param singleNode
//     * @param xPath
//     * @return
//     * @throws Exception
//     */
//    public static List<Node> getSingleNodeElementList(Node singleNode, String xPath) throws Exception {
//        return singleNode.selectNodes(xPath);
//    }
//
//    /**
//     * Ritorna il nome del nodeù
//     * 
//     * @param nod
//     * @return
//     * @throws Exception
//     */
//    public static String getNodeName(Node nod) throws Exception {
//        return nod.getName();
//    }
//
//    /**
//     * Ritorna il nome del Element
//     * 
//     * @param el
//     * @return
//     * @throws Exception
//     */
//    public static String getElementName(Element el) throws Exception {
//        return el.getName();
//    }
//
//    /**
//     * Ritorna il name della rootElement del documento
//     * 
//     * @param doc
//     * @return
//     * @throws Exception
//     */
//    public static String getRootElementName(Document doc) throws Exception {
//        return doc.getRootElement().getName();
//    }
}
