package collectionTest.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListTest
{
    public static void main(String[] args)
    {
        LinkedList<String> staff = new LinkedList<>();//�������϶���
        staff.add("aaa");// LinkedList.add()���Ԫ��,������β�����Ԫ��
        staff.add("bbb");
        staff.add("ccc");
        System.out.println(staff);
        Iterator<String> it = staff.iterator();//��������������
        it.next();
        it.next();
        it.remove();//ɾ���ڶ���Ԫ��
        System.out.println(staff);
        //��Ҫ�������м����Ԫ�أ���Ҫ������������λ�á�
        //����Iterator��ֻ��4��������hasNext();next();remove();forEachRemaining();û����������Ҫ��add����
        /*Iterator��һ���ӽӿڣ�
        * public interface ListIterator<E>
            extends Iterator<E>
        ���������������ĵ���������LinkedList.listIterator()�������ԷŻ����������;
        * */
        ListIterator<String> iter = staff.listIterator();
        /*add �ڵ�������λ��ǰ��!!!��ߣ����Ԫ��*/
        iter.next();//aaa|ccc--->��|����ʾ��������λ��
        iter.add("b22");//�ڵ�������λ��ǰ����ߣ����Ԫ��  aaa b22 | ccc
        iter.add("b33");//�ڵ�������λ��ǰ����ߣ����Ԫ��  aaa b22 b33 | ccc
        System.out.println(staff);
        /*previous ��ǰ�ƶ�������λ��,����Խ����Ԫ��*/
        System.out.println(iter.previous());//aaa b22 | b33 ccc
        iter.add("xxx");//aaa b22 xxx | b33 ccc
        System.out.println(iter.previous());//aaa b22 | xxx b33 ccc
        /*remove ɾ����һ�ε�����Խ����Ԫ�أ������һ����next������ɾ��������λ�����Ԫ�أ������һ����previous��ɾ��������λ���ұ�Ԫ��*/
        iter.remove();//aaa b22 | ccc,��������������remove
        System.out.println(staff);
        /*set �޸���һ�ε�����Խ����Ԫ�أ�������remove����*/
        iter.previous();//aaa | b22 ccc
        iter.set("bbb");
        System.out.println(staff);

        /*LinkedList.get��n�� ����λ�÷�������ĵ�n+1��Ԫ�أ�����������ʱ�临�Ӷ�ΪO(n),һ�㲻��*/
        System.out.println(staff.get(0));

    }
}