package xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.basic.BasicScrollPaneUI.VSBChangeListener;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXValidator;
import org.dom4j.io.XMLWriter;
import org.xml.sax.SAXException;

import util.FileUtil;
import xml_util.MyErrorHandler;
import xml_util.XMLDom4jUtility;



public class TestConfIniFileXml {

	public static final String XSD_EXT_FILE =".xsd"; 
	//public static final String IN_SCHEMA = "D:\\luca\\programs\\AS\\JBOSS_inem\\jboss-4.2.3.GA\\server\\default\\conf\\validators\\validator_del_sessionGroup.xsd";
	//public static final String IN_XML = "D:\\luca\\util\\EclipseWS\\inem\\Client-iEMX-IF\\FileXmlTest\\customserver\\requestSD4000\\session_group_4000\\tdelSessionGroup1.xml";
	
	public static final String VALIDATOR_DIR = "D:\\luca\\programs\\AS\\JBOSS_inem\\jboss-4.2.3.GA\\server\\default\\conf\\validators\\";
	public static final String IN_DIR = "D:\\luca\\util\\EclipseWS\\inem\\Client-iEMX-IF\\FileXmlTest\\customserver\\requestSD4000\\";
	
	public enum OP_TYPE {DEL, MOD, ADD};
	public enum FLOW_TYPE {h323stack, sessionAgent, sessionGroup,localPolicy,LRTLAN,LRTRER,NetworkIFInterctRER,RealmInterct,SipIFInterct,SipNatInterct,SteeringPoolInterct};
	
	public ArrayList<String> flowTypes =new ArrayList<String>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String validatorCompleteFileName ="";
		
			
		      // define the type of schema - we use W3C:
		      String schemaLang = "http://www.w3.org/2001/XMLSchema";

		      //FInd input files
		      List<String> listFilesInDir = FileUtil.listFilesInDir(new File(IN_DIR));
		      for (String fileName: listFilesInDir) {
		    	//  System.out.println("-- IN FILES --");
		    	//  System.out.println("-----> "+fileName);
		    	  
		      }
		      System.out.println("-- -- -- -- -- -- -- ");
		      
		    // FIND TEMPLATE NAME IN Input XML
		     
		      for (String inXmlFile: listFilesInDir) {
		    	  try {	  
		     
		      Document iniDocument = XMLDom4jUtility.parseFile(inXmlFile);
		   
		      List<Node> templateNodes = iniDocument.selectNodes("//templateName");
		      
		      if((templateNodes==null)||(templateNodes.size()==0)) {
		    	  System.out.println("-- templateName element NO FOUND IN INPUT FILE:"+ inXmlFile);
		    	  continue;
		      }else if((templateNodes.size()>1)) {
		    	  System.out.println("-- more than one templateName element FOUND IN INPUT FILE:"+ inXmlFile+", take the first one");
			    	 
		      }
		      Node templateNode = templateNodes.get(0);
		      Element templateEl= (Element)templateNode;
		     // System.out.println(" IN templateName:"+  templateEl.getText());
		      
		      String validatorFileName = "";
		      OP_TYPE op_Type=null;
		      	//--find Template TYPE
		      if(templateEl.getText().startsWith("tadd")) {
		    	  op_Type =OP_TYPE.ADD;
		    	  validatorFileName = "validator_add_";
		      }else if(templateEl.getText().startsWith("tmod")) {
		    	  op_Type =OP_TYPE.MOD;
		    	  validatorFileName = "validator_mod_";
		      }else if(templateEl.getText().startsWith("tdel")) {
		    	  op_Type =OP_TYPE.DEL;
		    	  validatorFileName = "validator_del_";
		      }
		      
		      if(op_Type!=null) {
		    //	  System.out.println(" IN template Type:"+  op_Type.name());					 
		      }else {
		    	  System.out.println(" OPERATION NOT supported:"+ templateEl.getText());
		    	  continue;	 
		      }
		     
		      FLOW_TYPE flow_Type=null;
		      boolean supportedFlow = false;
		      for(FLOW_TYPE  enum_flow_type: FLOW_TYPE.values()) {
		    	  if(templateEl.getText().contains(enum_flow_type.name().substring(1))) {
		    		  flow_Type=enum_flow_type;
		    		  supportedFlow = true;
		    		  
		    	  }
			    	  
		      }
//		      if(templateEl.getText().contains(FLOW_TYPE.h323stack.name().substring(1))){
//		    	  flow_Type = FLOW_TYPE.h323stack;
//		      }else if(templateEl.getText().contains(FLOW_TYPE.sessionAgent.name().substring(1))) {
//		    	  flow_Type = FLOW_TYPE.sessionAgent;
//		      }else 
//		    	  if(templateEl.getText().contains(FLOW_TYPE.sessionGroup.name().substring(1))) {
//		    	  flow_Type = FLOW_TYPE.sessionGroup;
//		      }else {
//		    	  supportedFlow=false;
//		      }
		    	
		      if(supportedFlow) {
		    	  	if(flow_Type==FLOW_TYPE.LRTRER){
		    	  		validatorFileName+="rer"+XSD_EXT_FILE;
		    	  	}else if(flow_Type==FLOW_TYPE.LRTLAN){
			    	  		validatorFileName+="lan"+XSD_EXT_FILE;
			    	}else if(flow_Type==FLOW_TYPE.NetworkIFInterctRER){
			    	  		validatorFileName+="NetworkIF"+XSD_EXT_FILE;
			    	}else if(flow_Type==FLOW_TYPE.RealmInterct){
			    	  		validatorFileName+="realm"+XSD_EXT_FILE;
			    	}else if(flow_Type==FLOW_TYPE.SipIFInterct){
			    	  		validatorFileName+="sipIf"+XSD_EXT_FILE;
			    	}else if(flow_Type==FLOW_TYPE.SipNatInterct){
			    	  		validatorFileName+="SipNat"+XSD_EXT_FILE;
			    	}else if(flow_Type==FLOW_TYPE.SteeringPoolInterct){
			    	  		validatorFileName+="SteeringPool"+XSD_EXT_FILE;
			    	}else{
		    	  			validatorFileName+=flow_Type.name()+XSD_EXT_FILE;
		    	  	}
		      		
		      }else {
		      		// System.out.println(" FLOW: "+ flow_Type+" unsupported");
			    	 continue;
		      }
		      
		       validatorCompleteFileName = VALIDATOR_DIR+validatorFileName;
		      
		      //---------complete InputXML
		      
		      //1. find sessionGroup node in document
		    		    //<checkOnDb>OK</checkOnDb><itemExistsOnDb>false</itemExistsOnDb><sdhanodes>  <SDHANode id="1">
              //<idOrder>-1081545965</idOrder>
		      		List<Node> nodeList = iniDocument.selectNodes("/"+flow_Type.name());
		      		if((nodeList==null)||(nodeList.size()==0)) {
		      			if((flow_Type.name().equals("LRTLAN"))||
		      				(flow_Type.name().equals("LRTRER"))	) {
		      				nodeList = iniDocument.selectNodes("/lrtAssociation");  		
		      			}else if(flow_Type.name().equals("NetworkIFInterctRER")) {
		      				nodeList = iniDocument.selectNodes("/networkInterface");  		
		      			}else if(flow_Type.name().equals("RealmInterct")) {
		      				nodeList = iniDocument.selectNodes("/realm");  		
		      			}else if(flow_Type.name().equals("SipIFInterct")) {
		      				nodeList = iniDocument.selectNodes("/sipIF");  		
		      			}else if(flow_Type.name().equals("SipNatInterct")) {
		      				nodeList = iniDocument.selectNodes("/sipNat");  		
		      			}else if(flow_Type.name().equals("SteeringPoolInterct")) {
		      				nodeList = iniDocument.selectNodes("/steeringPool");  		
		      			}else{
		      				System.out.println("node /"+flow_Type.name()+" doesn't exists in ini file:"+inXmlFile);
		      				continue;
		      			}
		      			
		      		}
		      		Node firstNode = nodeList.get(0);
	                Element sessGroupEl = (Element)firstNode;
	              	 
	                DocumentFactory instance = DocumentFactory.getInstance();
	                
	          //complete document     
	                if((flow_Type!=FLOW_TYPE.LRTLAN)&&
	                   (flow_Type!=FLOW_TYPE.LRTRER)) {
	                sessGroupEl.add(instance.createElement("checkOnDb").addText("OK"));
	                sessGroupEl.add(instance.createElement("itemExistsOnDb").addText("false"));	             
	                }
	                if((flow_Type==FLOW_TYPE.LRTLAN)) {
	                	sessGroupEl.add(instance.createElement("SDHANode"));
	                }else  {
	                	sessGroupEl.add(instance.createElement("sdhanodes"));
	                }
	                
	                // sessGroupEl.add(instance.createElement("idOrder").addText("123456789"));
	               
		       //print complete document on System.out
	             //   System.out.println("-- "+ inXmlFile+" completed ---"); 
	                OutputFormat format = OutputFormat.createPrettyPrint();
	                XMLWriter writer  = new XMLWriter( System.out, format );
	              //  writer.write(iniDocument);
	            //    System.out.println("-- --------------------"); 
		                     
		      //validate against schema
	                SAXParserFactory saxParsfactory = SAXParserFactory.newInstance();
	                saxParsfactory.setValidating(true);
	                saxParsfactory.setNamespaceAware( true);  
	                
	                SAXParser parser = saxParsfactory.newSAXParser();
	                parser.setProperty( "http://java.sun.com/xml/jaxp/properties/schemaLanguage",
	                                            "http://www.w3.org/2001/XMLSchema");
	                parser.setProperty( "http://java.sun.com/xml/jaxp/properties/schemaSource",
	                		validatorCompleteFileName  );

	                SAXValidator validator = new SAXValidator( parser.getXMLReader());
	                
	                validator.setErrorHandler(new MyErrorHandler());
	                validator.validate(iniDocument);
	
	                System.out.println("IN FILE:"+inXmlFile+" valid OK");
		      
		}catch (SAXException ex) {
		      // we are here if the document is not valid:
		      //ex.printStackTrace();
		    	System.out.println("!!!!!! IN FILE:"+inXmlFile+" NOT VALID,"+ex.getMessage()+", schema:"+validatorCompleteFileName);
		    } catch (Exception ex) {
		      ex.printStackTrace(); 	
		      System.out.println("!!!!!! IN FILE:"+inXmlFile+" NOT VALID,"+ex.getMessage()+", schema:"+validatorCompleteFileName);
		    }
		
		}
	
	}

}
