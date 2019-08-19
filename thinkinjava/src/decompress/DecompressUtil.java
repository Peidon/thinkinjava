package decompress;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class DecompressUtil {
	  /**
     * ��ѹ��zip�ļ�
     * @param file ѹ�����ļ�
     * @param targetPath Ŀ���ļ���
     */
    private static void decompressZip(File file, String targetPath){
        FileInputStream  fileInputStream = null;
        BufferedInputStream bufferedInputStream = null;
        GZIPInputStream gzipIn = null;
        ZipInputStream zipIn = null;
        OutputStream out = null;
        try {
            fileInputStream = new FileInputStream(file);
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            zipIn = new ZipInputStream(bufferedInputStream);

            // �������Ŀ¼
            createDirectory(targetPath, null);

            ZipEntry entry = null;
            while((entry = zipIn.getNextEntry()) != null){
                if(entry.isDirectory()){ // ��Ŀ¼
                    createDirectory(targetPath, entry.getName()); // ������Ŀ¼
                }else{ // ���ļ�
                    File tempFIle = new File(targetPath + File.separator + entry.getName());
                    createDirectory(tempFIle.getParent() + File.separator, null);
                    out = new FileOutputStream(tempFIle);
                    int len =0;
                    byte[] b = new byte[2048];

                    while ((len = zipIn.read(b)) != -1){
                        out.write(b, 0, len);
                    }
                    out.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(out != null){
                    out.close();
                }
                if(zipIn != null){
                    zipIn.close();
                }
                if(gzipIn != null){
                    gzipIn.close();
                }
                if(bufferedInputStream != null){
                    bufferedInputStream.close();
                }
                if(fileInputStream != null){
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     *  ����Ŀ¼
     * @param outputDir ���Ŀ¼
     * @param subDir ��Ŀ¼
     */
    private static void createDirectory(String outputDir, String subDir){
        File file = new File(outputDir);
        if(!(subDir == null || subDir.trim().equals(""))) {//��Ŀ¼��Ϊ��
            file = new File(outputDir + File.separator + subDir);
        }
        if(!file.exists()){
            if(!file.getParentFile().exists()){
                file.getParentFile().mkdirs();
            }
            file.mkdirs();
        }
    }
    
    public static void main(String[] args) {
    	DecompressUtil.decompressZip(new File("E:/Mydoc/SourceCode/repositories/thinkinjava/test.zip"), "E:/Mydoc/SourceCode/repositories/thinkinjava/");
	}
}
