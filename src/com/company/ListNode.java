package com.company;

public class ListNode {
    private int data;
    private ListNode previous;
    private  ListNode next;


    public ListNode findValue(int find) {
        ListNode current = this;
        while ((current != null) && (current.data != find)) {
            current = current.next;
        }
        return current;
    }
}
