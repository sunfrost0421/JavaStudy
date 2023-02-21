package ch10_2_3;

/*
* 要实现Operation接口，有以下四种方法
* 【1】常规类：heat
* 【2】匿名类：hammer
* 【3】方法引用：twist
* 【4】Lambda表达式：anneal
* */


class Heat implements Operation
{
    @Override
    public void execute() {
        Operation.show("Heat");
    }
}

public class MetalWork
{
    public static void main(String[] args) {
        Operation twist = new Operation() {
            @Override
            public void execute() {
                Operation.show("Twist");
            }
        };
        Operation.ranOps(new Heat(), new Operation() {
            @Override
            public void execute() {
                Operation.show("Hammer");
            }
        }, twist::execute , ()->Operation.show("Anneal"));

    }
}
