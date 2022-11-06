package stack;

import org.testng.annotations.Test;

public class ArrayStack {
    public int[] stack; // 数据存储
    public int maxSize; // 栈最大数量
    public int top = -1; // 栈顶位置

    public ArrayStack() {
    }

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack=new int[maxSize];
    }

    /**
     * 栈是否已满
     * @return
     */
    public boolean isFull(){
        return top==maxSize-1;
    }


    /**
     * 栈是否为空
     * @return
     */
    public boolean isEmpty(){
        return top==-1;
    }


    /**
     * 入栈：移动top指针，给数组赋值
     * @param value
     */
    public void push(int value) {
        if(isFull()){
            System.out.println("栈已满");
            return;
        }

        //等价于top++;  stack[top]=value;
        stack[++top]=value;
    }

    /**
     * 弹栈并返回弹栈的元素
     * @return
     */
    public int pop(){
        if (isEmpty()) {
            throw new RuntimeException("栈中无数据");
        }
        //
        //等价于：1 int value=stack[top];  先保存要弹栈的元素
        //      2 top--; 栈顶指针top减一
        //      3 return value;  返回弹栈的元素
        return stack[top--];
    }


    /**
     * 显示栈中数据，从栈顶开始显示，也就是按出栈的顺序显示
     */
    public void print(){
        if (isEmpty()) {
            System.out.println("栈中无数据");
            return;
        }
        for (int i = top; i >=0 ; i--) {
            System.out.println(stack[i]);
        }
    }

    @Test
    public void pushTest() {
        ArrayStack stack = new ArrayStack(4);
        stack.push(2);
        stack.push(1);
        stack.push(4);
        stack.push(3);
        stack.print();

        System.out.println("stack.isFull(): "+stack.isFull());
        stack.push(5);//栈已满,添加失败

        stack.pop();
        stack.print();

        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println("stack.isEmpty(): "+stack.isEmpty());
        stack.pop();//java.lang.RuntimeException: 栈中无数据
    }


}
