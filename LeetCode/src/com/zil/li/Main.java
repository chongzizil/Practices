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

    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    node1.next = node2;
    reorderList(node1);


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

  public static void reorderList(ListNode head) {
    if (head == null || head.next == null) {
      return;
    }

    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;

    ListNode l = head;
    ListNode mid = getMiddle(head);
    ListNode r = reverse(mid.next);
    mid.next = null;

    while (l != null && r != null) {
      curr.next = l;
      l = l.next;
      curr = curr.next;

      curr.next = r;
      r = r.next;
      curr = curr.next;
    }

    if (l != null) {
      curr.next = l;
    }
  }

  private static ListNode getMiddle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head.next;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    return slow;
  }

  private static ListNode reverse(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode curr = head;
    while (curr.next != null) {
      ListNode next = curr.next;
      curr.next = next.next;
      next.next = dummy.next;
      dummy.next = next;
    }
    return dummy.next;
  }
}
