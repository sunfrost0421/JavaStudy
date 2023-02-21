package ch10_2_3;

/*
* Ҫʵ��Operation�ӿڣ����������ַ���
* ��1�������ࣺheat
* ��2�������ࣺhammer
* ��3���������ã�twist
* ��4��Lambda���ʽ��anneal
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
