package com.zil.li;

import com.zil.li.DP.UniqueBinarySearchTrees;
import com.zil.li.datastructure.ListNode;
import com.zil.li.datastructure.TreeNode;
import com.zil.li.template.LinkedList;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by youlongli on 12/30/14.
 */
public class Main {
  public static void main(String[] args) throws IOException {
//
//    ListNode node1 = new ListNode(1);
//    ListNode node2 = new ListNode(2);
//    node2.next = node1;
//    partition(node2, 2);


    File dir = new File("");
    File[] comics = dir.listFiles();
    for (File comic: comics) {
      File[] subDirs = comic.listFiles();
      File[] images = subDirs[0].listFiles();
      if (images == null) {
        continue;
      }
      for (File image : images) {
        Path src = FileSystems.getDefault().getPath(image.getPath());
        Path tar = FileSystems.getDefault().getPath(comic.getPath() + "\\" + image.getName());
        Files.move(src, tar);
      }
      subDirs[0].delete();
    }
  }

  public static ListNode partition(ListNode head, int x) {
    ListNode small = new ListNode(0);
    ListNode currS = small;
    ListNode large = new ListNode(0);
    ListNode currL = large;

    while (head != null) {
      if (head.val < x) {
        currS.next = head;
        currS = currS.next;
      } else {
        currL.next = head;
        currL = currL.next;
      }
      head = head.next;
    }

    currS.next = large.next;
    return small.next;
  }
}
