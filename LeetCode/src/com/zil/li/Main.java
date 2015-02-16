package com.zil.li;

import com.zil.li.DP.UniqueBinarySearchTrees;
import com.zil.li.datastructure.ListNode;
import com.zil.li.datastructure.TreeNode;
import com.zil.li.template.LinkedList;

import java.io.IOException;

/**
 * Created by youlongli on 12/30/14.
 */
public class Main {
  public static void main(String[] args) throws IOException {

    UniqueBinarySearchTrees test = new UniqueBinarySearchTrees();
    long start = System.currentTimeMillis();
    test.solutionA(200000);
    System.out.println(System.currentTimeMillis() - start);
    start = System.currentTimeMillis();
    test.solutionB(200000);
    System.out.println(System.currentTimeMillis() - start);

//    File dir = new File("D:\\BaiduYunDownload\\同人 01.30");
//    File[] comics = dir.listFiles();
//    for (File comic: comics) {
//      File[] subDirs = comic.listFiles();
//      File[] images = subDirs[0].listFiles();
//      for (File image : images) {
//        Path src = FileSystems.getDefault().getPath(image.getPath());
//        Path tar = FileSystems.getDefault().getPath(comic.getPath() + "\\" + image.getName());
//        Files.move(src, tar);
//      }
//      subDirs[0].delete();
//    }
  }
}
