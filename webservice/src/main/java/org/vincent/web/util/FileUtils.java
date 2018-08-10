package org.vincent.web.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PengRong on 2018/8/8.
 * @author PengRong
 * @date 2018/08/08
 */
public class FileUtils {
    public  static  void  main(String[] args) throws IOException {
        List<String> list=new ArrayList<>();
        getFileNameList("D:\\DowJones\\HK\\20170906\\",list);
        System.out.println(list);
        clear(null);

    }
    /**
     * 清除 file 实例所指向的文件内容 </p>
     * @param file 待清空内容的文件 </p>
     */
    public static void clear(File file) throws IOException {
        if (file ==null ) {
            return;
        }
        if (file.exists() && file.isFile()){
            //删除文件
            boolean isDelete=file.delete();
            if (isDelete){
                //新建文件
                file.createNewFile();
            }
        }
    }

    /**
     *  根据文件夹路径，递归调用获取该文件夹下所有文件 </p>
     * @param filepath 待遍历的文件夹目录 </p>
     * @param filePathList 所有文件的绝对路径 List
     * @return 返回遍历目录下所有文件的绝对路径List
     */
    public static List<String> getFileNameList(String filepath, List<String> filePathList) throws IOException {

        if (filepath == null){
            return filePathList;
        }
        if(null == filePathList){
            filePathList = new ArrayList<>();
        }
        /** 去除 filepath目录 字符串最后的路径分隔符 */
        if (filepath.substring(filepath.length()-1).equalsIgnoreCase(File.separator) ){
            filepath=filepath.substring(0,filepath.length()-1);
        }
        File file = new File(filepath);
        if (!file.isDirectory()) {
            filePathList.add(file.getCanonicalFile().getPath());
        } else if (file.isDirectory()) {
            /** 获取当前目录下所有文件的文件名: 包括文件和文件夹； 单纯只是文件名和文件夹名 */
            String[] fileList = file.list();
            for (int i = 0; i < fileList.length; i++) {
                File readfile = new File(filepath + File.separator + fileList[i]);
                //过滤压缩文件
                /*if (readfile.getName().endsWith(".zip")) {
                    continue;
                }*/
                if (!readfile.isDirectory()) {
                    filePathList.add(readfile.getPath());
                } else if (readfile.isDirectory()) {
                    getFileNameList(filepath + File.separator + fileList[i],filePathList);
                }
            }
        }
        return filePathList;
    }
}
