package com.niit.laptop.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

	public static void upload(String path, MultipartFile file, String name) 
	{
		
		if(!file.isEmpty())
		{
        InputStream in = null;
        OutputStream out = null;
         if(file.getSize()>0)
         {
        	 try
        	 {
        		 in = file.getInputStream();
        		 out = new FileOutputStream(path + name);
        		 int readbytes = 0;
        		 byte[] buffer = new byte[1024];
        		 while ((readbytes = in.read(buffer, 0, 1024)) != -1)
        		 {
        			 out.write(buffer, 0, readbytes);
        			 
        		 }
        	 }
        	 
        	 catch (Exception ex)
        	 {
        		 ex.printStackTrace();
        		 
        	 }
        	 
        	 finally
        	 {
        		 try
        		 {
        			 
        			 out.close();
        			 in.close();
        		 }
        		 
        		 catch (IOException ex)
        		 {
        			 
        			 ex.printStackTrace();
        			 
        			 
        		 }
        		 }
        	 }
         
         
		}


	}
}



