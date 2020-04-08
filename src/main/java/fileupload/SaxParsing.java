package fileupload;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author test
 */
public class SaxParsing {

    public static void x(){
        
    }
    
    public static ForumTableDataParser parseit(InputStream fileStream) {
       
        
        ForumTableDataParser ftdp = new ForumTableDataParser();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            
                SAXParser parser = factory.newSAXParser();
            try {
                parser.parse(fileStream, ftdp);
            } catch (IOException ex) {
                Logger.getLogger(SaxParsing.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(SaxParsing.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(SaxParsing.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ftdp;
    }
}
