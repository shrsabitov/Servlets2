package fileupload;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class ForumTableDataParser extends DefaultHandler {

    private ArrayList<TableInfo> parsedData=new ArrayList();
    private TableInfo rs;
    private String thisElement = "";

    public ArrayList<TableInfo> getParsedData() {
        return parsedData;
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        try {
            if (thisElement.equals("postid")) {
                rs.setPostId(new Integer(new String(ch, start, length)));
            } else if (thisElement.equals("text")) {
                rs.setPostText(new String(ch, start, length));
            } else if (thisElement.equals("topic_id")) {
                rs.setTopicId(new Integer(new String(ch, start, length)));
            } else if (thisElement.equals("user_id")) {
                rs.setUserId(new Integer(new String(ch, start, length)));
            } else if (thisElement.equals("date")) {
                rs.setPostDate(new String(ch, start, length));
                System.out.println(new String(ch, start, length));
            }
        } catch (Exception e) {
        }

    }

    @Override
    public void endDocument() {
        System.out.println("��������� ��������� �����.");
    }

    @Override
    public void endElement(String uri, String localName, String qName)  {
        thisElement = "";
        System.out.println("��������� ������� xml: " + qName);
    }

    
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)  {
           try{
        super.startElement(uri, localName, qName, attributes);
        }
        catch(SAXException e){
            System.out.println("������ �:  "+qName);
        }
        
        
        System.out.println("������ ������� ������� XML: "+qName);
        
        thisElement = qName;
        if (qName == "post") {
            rs = new TableInfo();
            parsedData.add(rs);
        }
    }

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        
        SAXParser parser = null;
        ForumTableDataParser ftdp = null;

        File f = new File("c://forum_posts2.xml");



//        а вот так можно считывать из файлового или иного потока
//         InputStream is = null;
//        try {
//            is=new FileInputStream(f);
//            
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(SAX.class.getName()).log(Level.SEVERE, null, ex);
//        }


        try {
            parser = factory.newSAXParser();
            ftdp = new ForumTableDataParser();
            try {
                parser.parse(f, ftdp);
//                parser.parse(is, s); в случае потока
            } catch (IOException ex) {
                
            }
        } catch (ParserConfigurationException pe) {
            
        }
        catch(SAXException ex ){
            System.out.println("SAXException Пизнес!");
        }


        ArrayList<TableInfo> parseData = ftdp.getParsedData();

        Iterator<TableInfo> it = parseData.iterator();
        while (it.hasNext()) {

            System.out.println("тексты постов=" + it.next().getPostText());
        }


    }
}
