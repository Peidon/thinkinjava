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
     * 解压缩zip文件
     * @param file 压缩包文件
     * @param targetPath 目标文件夹
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

            // 创建输出目录
            createDirectory(targetPath, null);

            ZipEntry entry = null;
            while((entry = zipIn.getNextEntry()) != null){
                if(entry.isDirectory()){ // 是目录
                    createDirectory(targetPath, entry.getName()); // 创建子目录
                }else{ // 是文件
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
     *  构建目录
     * @param outputDir 输出目录
     * @param subDir 子目录
     */
    private static void createDirectory(String outputDir, String subDir){
        File file = new File(outputDir);
        if(!(subDir == null || subDir.trim().equals(""))) {//子目录不为空
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
