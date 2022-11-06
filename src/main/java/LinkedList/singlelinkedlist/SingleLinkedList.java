package LinkedList.singlelinkedlist;

import org.testng.annotations.Test;

/**
 * 一个节点的next指向新的节点
 * 假设当前节点是headNode头节点， 头节点next一次，则定位到firstNode(第一个有效节点)，再next一次，则定位到第二个有效节点。。。
 * 当前节点next==null时，说明当前节点是链表的最后一个节点
 */
public class SingleLinkedList {

    // 头节点，不保存任何数据，只是用来作为一个起始node来遍历链表
    //可以把head.next想象成定位/指向当前节点的指针
    private HeroNode head = new HeroNode(0, "", "");


    /**
     * 链表尾部追加节点
     * 1. 找到当前链表的最后节点
     * 2. 将最后整个节点的 next 指向新的节点
     *
     * @param node
     */
    public void add(HeroNode node) {
        //head是头节点节点，head.next永远指向第一个firstnode节点，head.next永远保存着第一个节点对象的地址；
        //链表需要从头节点开始遍历，因此头节点需要保持固定不变，所以需要一个临时节点作为head节点的副本，用其来遍历链表
        HeroNode temp = head;

        //循环结束后，tmp.next==null,说明此时tmp节点引用是最后一个节点， tmp节点是最后一个节点对象的引用
        while (temp.next != null) {
            temp = temp.next;//节点后移
        }

        //最后一个节点的next指向新的节点
        temp.next = node;
    }


    /**
     * 链表尾部追加节点方式2
     *
     * @param node
     */
    public void add2(HeroNode node) {
        // 要遍历到 next 为 null 的时候，才能进行添加
        HeroNode temp = head;
        while (true) {
            // 找到链表的最后,就退出循环
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }



    /**
     * 遍历链表
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
     * 遍历链表方式2
     */
    public void list2() {

        //若头节点的next==null,说明这是一个空链表
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head;//temp最开始指向定位到第一个有效节点firstnod头节点
        while (true) {

            //如果temp.next == null,说明temp是链表最后一个元素，跳出循环
            if (temp.next == null) {
                break;
            }

            System.out.println(temp.next);//首次循环的temp.next是链表的第一个有效节点firstnode
            temp = temp.next;//首次循环，打印完第一个有效节点firstnode后，temp就后移定位到第一个有效节点firstnode


        }
    }

    /**
     * 遍历链表方式2
     */
    public void list3() {

        //若头节点的next==null,说明这是一个空链表
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;//temp最开始指向定位到第一个有效节点firstnode
        while (true) {

            // 如果是链表的最后
            if (temp == null) { //判断前面的head.next和后面的temp.next是否为空
                break;
            }

            System.out.println(temp);//首次循环打印第一个有效节点firstnode
            temp = temp.next;//首次循环temp就后移定位到第二个有效节点


        }
    }

    @Test
    public void listTest() {
        //创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建链表并添加节点
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);

        //遍历节点
        singleLinkedList.list();
    }


    /**
     * 按添加顺序输出，如果添加的no是乱序的，那么输出也是乱序的
     */
    @Test
    public void listTest2() {
        //创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建链表并添加节点
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero2);

        //遍历节点
        singleLinkedList.list2();
    }


    /**
     * 1. 先找到该节点要添加的位置或者说找到添加位置的前一个节点，如果按照id排序，遍历的时候发现某个节点的id大于待插入的节点的id，那么就插在这个节点的后面
     * 2. 改变前一个和该节点的 next 指向
     *
     * @param newNode
     */
    public void addByOrder(HeroNode newNode) {
        HeroNode temp = head; //temp最开始指向头节点
        while (true) {

            // temp.next == null说明temp是是链表尾部元素，那么把新节点直接插在temp节点后面
            if (temp.next == null) {
                temp.next= newNode;
                break;
            }

            // 如果当前节点tmp的下一个节点tmp.next的id等于目标节点的id，则表示链表中已经存在目标节点了
            if (temp.next.no == newNode.no) {
                System.out.printf("准备插入的英雄编号 %d 已经存在，不能加入 \n", newNode.no);
                break;
            }


            //{如果当前节点tmp的下一个节点tmp.next的id大于待插入的节点的id，那么就插在这个节点tmp和这个节点的下个节点tmp.next之间，就比如把3插入在head-->1-->2-->4-->5,
            if (temp.next.no > newNode.no) {
                // 把节点插入到 temp 和 temp.next 之间
                // temp  ->  node  -> temp.next
                newNode.next = temp.next;
                temp.next = newNode;
                break;
            }

            // 没找到，则后移 temp ，继续寻找
            temp = temp.next;
        }

    }





    /**
     * 1. 先找到该节点要添加的位置或者说找到添加位置的前一个节点，如果按照id排序，遍历的时候发现某个节点的id大于待插入的节点的id，那么就插在这个节点的后面
     * 2. 改变前一个和该节点的 next 指向
     *
     */
    public void addByOrder2(HeroNode node) {
        // 由于 head 变量不能动，动了就无法从头遍历了，使用辅助变量来完成我们的添加
        HeroNode temp = head;
        boolean exist = false;  // 添加的节点是否已经在链表中存在
        while (true) {
            if (temp.next == null) {
                // 如果是链表尾，则跳出循环
                break;
            }
            // 如果当前节点的 next 编号，大于目标节点编号，则找到
            // 应该将目标节点添加到  temp 与 next 之间
            if (temp.next.no > node.no) {
                break;
            }


            // 如果他们相等，则表示链表中已经存在目标节点了
            if (temp.next.no == node.no) {
                exist = true;
                break;
            }
            // 没找到，则后移 temp ，继续寻找
            temp = temp.next;
        }

        if (exist) {
            System.out.printf("准备插入的英雄编号 %d 已经存在，不能加入 \n", node.no);
            return;
        }
        // 把节点插入到 temp 和 temp.next 之间
        // temp  ->  node  -> temp.next
        node.next = temp.next;
        temp.next = node;
    }

    @Test
    public void addByOrderTest() {
        //创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建链表并添加节点
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero3);//重复插入

        //遍历节点
        singleLinkedList.list();
    }

    public void update(HeroNode newNode){
        if (head.next == null) { //头节点的next为空，说明是空链表
            System.out.println("链表为空");
            return;
        }
        HeroNode temp=head.next; //temp指向firstNode
        boolean exist = false;  // 是否找到要修改的节点

        while (true) {

            // 如果已找到
            if (temp.no == newNode.no) {
                exist = true;
                break;
            }

            //后移
            temp = temp.next;


            // 如果是链表尾部
            if (temp == null) {
                break;
            }
        }
        if (exist) {
            temp.name = newNode.name;
            temp.nickName = newNode.nickName;
        } else {
            System.out.printf("未找到编号为 %d 的英雄", newNode.no);
        }
    }




    public void update2(HeroNode newNode){
        if (head.next == null) { //头节点的next为空，说明是空链表
            System.out.println("链表为空");
            return;
        }
        HeroNode temp=head; //temp指向头节点
        boolean exist = false;  // 是否找到要修改的节点

        while (temp.next!=null) {//当tmp指向最后一个节点时候，tmp.next==null

            // 如果已找到
            if (temp.next.no == newNode.no) {
                exist = true;
                break;
            }
            //后移
            temp = temp.next;
        }
        if (exist) {
            temp.next.name = newNode.name;
            temp.next.nickName = newNode.nickName;
        } else {
            System.out.printf("未找到编号为 %d 的英雄", newNode.no);
        }
    }




    @Test
    public void updateTest() {
        //创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建链表并添加节点
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);

        //遍历节点
        System.out.println("修改前");
        singleLinkedList.list();
        HeroNode hero4New = new HeroNode(4, "林冲-修改测试", "豹子头-修改测试");
        singleLinkedList.update2(hero4New);
        System.out.println("修改后");
        singleLinkedList.list();
    }

    /**
     * <pre>
     *   按编号删除节点
     *   1. 找到要删除节点的前一个节点
     *   2. 然后将这个前一个节点的 next 指向变更到要删除节点的 next 节点
     * </pre>
     *
     * @param no
     */
    public void delete(int no) {

        //头节点的next为空，说明是空链表
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode temp = head; //temp指向head
        boolean exist = false;  //是否找到要删除的节点
        while (true) {

            if (temp.next.no == no) {//首次循环的时候temp.next指向firstNode, 若temp.next.no == no， temp就是要删除节点的前一个节点
                exist = true;
                break;
            }

            //后移
            temp = temp.next;
            if (temp.next == null) {
                break;
            }
        }
        if (!exist) {
            System.out.printf("未找到匹配的编号 %d \n", no);
            return;
        }
        // 删除操作
        temp.next = temp.next.next;
    }

    @Test
    public void deleteTest() {
        //创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建链表并添加节点
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);

        //遍历节点
        System.out.println("删除前");
        singleLinkedList.list();
        singleLinkedList.delete(1);
        singleLinkedList.delete(4);
        System.out.println("删除后");
        singleLinkedList.list();
    }


    /**
     * 求单链表中有效节点的个数
     * @return
     */
    public int length() {
        HeroNode temp = head;
        int num = 0;
        while (temp.next != null) {
            num++;
            temp = temp.next;
        }
        return num;
    }

    @Test
    public void lengthTest() {
        //创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建链表并添加节点
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);

        System.out.println(singleLinkedList.length());
        singleLinkedList.delete(1);
        singleLinkedList.delete(2);
        singleLinkedList.delete(3);
        singleLinkedList.delete(4);
        System.out.println(singleLinkedList.length());
    }




}
