package fileupload;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author test
 */
public class FileUploading2 {
    public static InputStream upload(HttpServletRequest request) {
        List fileItemsList = null;
        InputStream fileStream = null;

        ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
        try {
            fileItemsList = servletFileUpload.parseRequest(request);
        } catch (FileUploadException ex) {
            Logger.getLogger(B_ReadXML.class.getName()).log(Level.SEVERE, null, ex);
        }

        @SuppressWarnings({"null", "ConstantConditions"})
        Iterator it = fileItemsList.iterator();
        while (it.hasNext()) {
            FileItem fileItem = (FileItem) it.next();
            if (fileItem.isFormField()) {
            } else {
                try {
                    fileStream = fileItem.getInputStream();
                } catch (IOException ex) {
                    Logger.getLogger(FileUploading2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return fileStream;
    }
    
}
