package LinkedList.doublelinkedlist;

/**
 * https://zq99299.github.io/dsalg-tutorial/dsalg-java-hsp/04/03.html
 */
public class DoubleLinkedList {
    private HeroNode head = new HeroNode(0, "", "");


    /**
     * 遍历链表,同单链表
     */
    public void list() {
        //若头节点的next==null,说明这是一个空链表
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head;//临时变量temp指向头节点
        while (temp.next != null) {
            System.out.println(temp.next);//首次循环的temp.next是链表的第一个有效节点firstnode
            temp = temp.next;//首次循环，打印完第一个有效节点firstnode后，temp就后移定位到第一个有效节点firstnode
        }
    }



    /**
     * 添加：将节点添加到链表尾部
     * @param node
     */
    public void add(HeroNode node) {
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }//while结束后，tmp就是最后一个节点元素


        // 将新节点添加到末尾的节点上
        temp.next = node;
        node.pre = temp;
    }


    /**
     * 更新节点，同单向链表
     * @param newNode
     */
    public void update(HeroNode newNode){
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode temp = head.next;
        boolean exist = false;  // 是否找到要修改的节点

        while (true) {
            // 如果已找到
            if (temp.no == newNode.no) {
                exist = true;
                break;
            }
            temp = temp.next;
        }
        // 如果已找到，则修改信息
        if (exist) {
            temp.name = newNode.name;
            temp.nickName = newNode.nickName;
        } else {
            System.out.printf("未找到编号为 %d 的英雄", newNode.no);
        }
    }


    public void update2(HeroNode newNode){
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode temp = head;
        boolean exist = false;  // 是否找到要修改的节点

        while (temp.next!=null) {
            // 如果已找到
            if (temp.next.no == newNode.no) {
                exist = true;
                break;
            }
            temp = temp.next;
        }
        // 如果已找到，则修改信息
        if (exist) {
            temp.next.name = newNode.name;
            temp.next.nickName = newNode.nickName;
        } else {
            System.out.printf("未找到编号为 %d 的英雄", newNode.no);
        }
    }

    /**
     * <pre>
     * 删除：按编号匹配，将其删除；
     *  思路：直接找到该节点，然后自我删除
     * </pre>
     *
     * @param no
     */
    public void delete(int no) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode tmp = head.next; //指向被删除的节点
        boolean exist = false;  // 是否找到要删除的节点
        while (true) {
            if (tmp == null) {
                break;//链表最后
            }
            // 找到与自己相同的 id
            if (tmp.no == no) {
                exist = true;
                break;
            }
            tmp = tmp.next;
        }
        if (!exist) {
            System.out.printf("未找到匹配的编号 %d \n", no);
            return;
        }


        if (tmp.next != null) {//如果不是最后一个元素
            tmp.pre.next = tmp.next;
            tmp.next.pre = tmp.pre;
        } else {
            tmp.pre.next = tmp.next;// 如果是最后一个元素
        }


    }
}
