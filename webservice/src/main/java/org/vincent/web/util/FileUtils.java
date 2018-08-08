package org.vincent.web.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PengRong on 2018/8/8.
 */
public class FileUtils {
    public  static  void  main(String[] args) throws IOException {
        List<String> list=new ArrayList<>();
        getFileNameList("D:\\DowJones\\HK\\20170906\\",list);
        System.out.println(list);

    }
    /**
     * 清除 file 实例所指向的文件内容
     * @param file
     */
    public static void clear(File file) throws IOException {

        if (file ==null )return;
        if (file.exists() && file.isFile()){
            file.delete();//删除文件
            file.createNewFile();//新建文件
        }
    }

    /**
     *  根据文件夹路径，递归调用获取该文件夹下所有文件 </p>
     * @param filepath 待遍历的文件夹目录 </p>
     * @param filePathList 所有文件的绝对路径 List
     * @return
     */
    public static List<String> getFileNameList(String filepath, List<String> filePathList) throws IOException {

        if (filepath == null) return filePathList;
        if(null == filePathList){
            filePathList = new ArrayList<String>();
        }
        /** 去除 filepath目录 字符串最后的路径分隔符 */
        if (filepath.charAt(filepath.length()-1)=='\\'){
            filepath=filepath.substring(0,filepath.length()-1);
        }
        File file = new File(filepath);
        if (!file.isDirectory()) {
            filePathList.add(file.getCanonicalFile().getPath());
        } else if (file.isDirectory()) {
            /** 获取当前目录下所有文件的文件名: 包括文件和文件夹； 单纯只是文件名和文件夹名 */
            String[] filelist = file.list();
            for (int i = 0; i < filelist.length; i++) {
                File readfile = new File(filepath + File.separator + filelist[i]);
                //过滤压缩文件
                /*if (readfile.getName().endsWith(".zip")) {
                    continue;
                }*/
                if (!readfile.isDirectory()) {
                    filePathList.add(readfile.getPath());
                } else if (readfile.isDirectory()) {
                    getFileNameList(filepath + File.separator + filelist[i],filePathList);
                }
            }
        }
        return filePathList;
    }
}
