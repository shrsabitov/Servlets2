package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HelpClass {

    public static String ComboTag(ResultSet r, String fieldName, String selectName) {
        StringBuilder s = new StringBuilder();
        s.append("<select name="+selectName+">");
        try {
            while (r.next()) {
                s.append("<option>");
                s.append(r.getString(fieldName));
                s.append("</option>");
            }
        } catch (SQLException ex) {
            Logger.getLogger(HelpClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        s.append("</select>");
        return s.toString();
    }
}
