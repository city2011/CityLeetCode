package array;

public class A {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        A m = new A();
        ListNode listnode1 = new ListNode(1);
        ListNode listnode12 = new ListNode(3);
        ListNode listnode13 = new ListNode(4);
        ListNode listnode2 = new ListNode(2);
        ListNode listnode21 = new ListNode(3);
        ListNode listnode22 = new ListNode(5);

        listnode1.next = listnode12;
        listnode12.next = listnode13;

        listnode2.next = listnode21;
        listnode21.next = listnode22;

        ListNode resNode = m.combineTwoListNode(listnode1, listnode2);

        while(resNode != null){
            System.out.println(resNode.val);
            resNode = resNode.next;
        }
    }

    private ListNode combineTwoListNode(ListNode listnode1, ListNode listnode2){
        ListNode resNode = new ListNode();
        ListNode x = new ListNode();
        resNode = x;
        while(listnode1 != null || listnode2 != null){
            if(listnode1 == null){
                x.next = listnode2;

                break;
            } else if(listnode2 == null){
                x.next = listnode1;
                break;
            } else {
                if(listnode1.val > listnode2.val){
                    x.next = listnode2;
                } else {
                    x.next = listnode1;
                }
                x = x.next;
            }
        }
        return resNode.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(){
        }

        ListNode(int v){
            this.val = v;
        }
    }
}
