package algorithm;

import java.util.List;
/**+-------------------------
 * |It's my SinglyLinkedList
 * +-------------------------
 * @author Xu
 * 
 * @param <Object>
 */
public class SinglyLinkedList {

	transient int size = 0;

	transient Node head = null;

	public SinglyLinkedList() {
	}

	public void reverse() {
		Node pre = null;
		Node q;
		while(head.next != null){
			q = head;	// mark the quondam head
			head = head.next; // now head is changed
			q.next = pre; // quondam head convert to the last one
			pre = q;
		}
		head.next = pre;
	}

	private class Node {
		Object item;
		Node next;

		Node(Object element, Node next) {
			this.item = element;
			this.next = next;
		}
	}

	public boolean addAll(List<Integer> list) {
		Object[] a = list.toArray();
		int numNew = a.length;
		if (numNew == 0)
			return false;
		Node pre = head;
		for (Object o : a) {
			Object e =  o;
			final Node newNode = new Node(e, null);
			if(pre == null){
				head = newNode;
			}else{
				pre.next = newNode;
			}
			pre = newNode;
		}
		size +=numNew;
		return true;
	}
	public void print() {
        for (Node x = head; x != null; x = x.next)
            System.out.print(" "+x.item+" ");
    }
	public Object getHead(){
		return head.item;
	}

	public int compareTo(Object o) {
		return 0;
	}
}
