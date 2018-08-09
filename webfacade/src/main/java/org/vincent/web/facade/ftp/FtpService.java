package org.vincent.web.facade.ftp;

import java.io.File;
import java.util.List;

/**
 * Ftp service Interface.
 * Created by PengRong on 2018/8/9.
 * @author PengRong
 */
public interface FtpService {
    /**
     *
     * 将 uploadFile 文件夹上传到 dstDir 目录下。</p>
      * @param uploadFile 待上传文件</p>
     * @param dstDir Ftp 服务器存储文件基目录</p>
     * @return 返回是否上传成功 </p>
     * @author PengRong
     */
    public  boolean uploadFile(File uploadFile,String dstDir);

    /**
     *  将Ftp 服务器上面一个文件夹目录下的所有文件下载到dstDir指向的目录下
     * @param srcDir Ftp 服务器上一个文件夹目录字符串 </p>
     * @param dstDir 本地主机下一个文件夹目录字符串 </p>
     * @return
     */
    public List<String> fetchFiles(String srcDir,String dstDir,Filter filter);
}
