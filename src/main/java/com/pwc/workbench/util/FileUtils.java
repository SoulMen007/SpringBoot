package com.pwc.workbench.util;

import org.springframework.util.ResourceUtils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;


public class FileUtils {
	
    /**
     * 文件转base64字符串
     * @param file
     * @return
     */
    public static String fileToBase64(File file) {
        String base64 = null;
        InputStream in = null;
        try {
            in = new FileInputStream(file);
            byte[] bytes = new byte[(int)file.length()];
            in.read(bytes);
            base64 = Base64.getEncoder().encodeToString(bytes);
        } catch (FileNotFoundException e) {            
            e.printStackTrace();
        } catch (IOException e) {            
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {                
                e.printStackTrace();
            }
        }
        return base64;
    }

    /**
     * base64字符串转文件并传入特定目录
     * @param base64
     * @return
     */
    public static void base64ToFile(String filePath,String base64,String timestampFileName) {
        File file = null;     
        //创建文件目录
    	File dir=new File(filePath);
    	if (!dir.exists() && !dir.isDirectory()) {
    		dir.mkdirs();
    	}
    	BufferedOutputStream bos = null;
    	FileOutputStream fos = null;
    	try {
    		byte[] bytes = Base64.getDecoder().decode(base64);
    		file=new File(filePath+"\\"+timestampFileName);
    		fos = new java.io.FileOutputStream(file);
    		bos = new BufferedOutputStream(fos);
    		bos.write(bytes);        		
    	}catch (Exception e) {
            e.printStackTrace();
        } finally {
        	if (bos != null) {
        		try {
        			bos.close();
        		}catch (IOException e) {
        			e.printStackTrace();
        		}
        	}
        	if (fos != null) {
        		try {
        			fos.close();
        		}catch (IOException e) {
        			e.printStackTrace();
        		}
        	}
        }            
    }

    /**
     * 通过文件名获取根目录下的文件
     * @param fileName
     * @return
     * @throws IOException
     */
    public static File getTempFileByFileName(String fileName) throws IOException {
        File tempBootPath = new File(ResourceUtils.getURL("classpath:").getPath());
        if(!tempBootPath.exists()){
            tempBootPath = new File("");
        }
        String tempFileName = tempBootPath.getAbsoluteFile()+File.separator+fileName;
        File tempFile = new File(tempFileName);
        if(!tempFile.exists()){
            tempFile.createNewFile();
        }
        return tempFile;
    }
}
