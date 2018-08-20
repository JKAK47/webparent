package org.vincent.web.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PengRong on 2018/8/8.
 *
 * @author PengRong
 * @date 2018/08/08
 */
public class FileUtils {
		/**
		 * 文件名组成：文件名 + 扩展名 ，这两部分间通过点号区分
		 */
		public static final String DOT = ".";

		public static void main(String[] args) throws IOException {
				List<String> list = new ArrayList<>();
				getFileNameList("D:\\DowJones\\HK\\20170906\\", list);
				System.out.println(list);
				clear(null);

		}

		/**
		 * 清除 file 实例所指向的文件内容 </p>
		 *
		 * @param file 待清空内容的文件 </p>
		 */
		public static void clear(File file) throws IOException {
				if (file == null) {
						return;
				}
				if (file.exists() && file.isFile()) {
						//删除文件
						boolean isDelete = file.delete();
						if (isDelete) {
								//新建文件
								file.createNewFile();
						}
				}
		}

		/**
		 * 根据一个file 实例，代表一个抽象的目录字符串，抽象路径字符串必须是绝对路径。
		 * 这个字符串可能代表一个目录，可能代表一个文件的路径字符串；
		 * 其中的目录，可能一些文件夹不存在，这个方法是把不存在的目录和文件创建成功。
		 *
		 * @param file 虚拟字符串创建的file 实例
		 */
		public static File touchFile(File file) throws IOException {
				if (!file.exists()) {
						/** 去除 filepath目录 字符串最后的路径分隔符 */
						String filepath = file.getCanonicalPath();
						if (filepath.substring(filepath.length() - 1).equalsIgnoreCase(File.separator)) {
								filepath = filepath.substring(0, filepath.length() - 1);
								file=new File(filepath);
						}

						//判定当前file表示的抽象字符串是否是文件还是文件夹，根据目录最后的文件或文件夹名称是否有点
						String name = file.getName();
						//是文件
						if (name != null && name.indexOf(FileUtils.DOT) != -1) {
								if (!file.getParentFile().exists()) {
										file.getParentFile().mkdirs();
								}
								file.createNewFile();
						} else {
								// 是目录
								file.mkdirs();
						}

				}
				return file;
		}

		/**
		 * 根据文件夹路径，递归调用获取该文件夹下所有文件路径字符串 </p>
		 *
		 * @param filepath     待遍历的文件夹目录 </p>
		 * @param filePathList 所有文件的绝对路径 List
		 * @return 返回遍历目录下所有文件的绝对路径List
		 */
		public static List<String> getFileNameList(String filepath, List<String> filePathList) throws IOException {

				if (filepath == null) {
						return filePathList;
				}
				if (null == filePathList) {
						filePathList = new ArrayList<>();
				}
				/** 去除 filepath目录 字符串最后的路径分隔符 */
				if (filepath.substring(filepath.length() - 1).equalsIgnoreCase(File.separator)) {
						filepath = filepath.substring(0, filepath.length() - 1);
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
										getFileNameList(filepath + File.separator + fileList[i], filePathList);
								}
						}
				}
				return filePathList;
		}
}
