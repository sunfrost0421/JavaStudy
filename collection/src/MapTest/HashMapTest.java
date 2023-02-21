package MapTest;

import java.util.*;

public class HashMapTest
{
    public static void main(String[] args)
    {
        var lover = new HashMap<String,String>();

        lover.put("hjx","qrc");//��Ӽ�ֵ�ԣ�����Ǽ����ұ���ֵ
        lover.put("zzy","ly");
        lover.put("sy","qyy");
        lover.containsKey("hjx");
        lover.replace("zzy", "LY");

        System.out.println("HASHCODE:   "+"hjx".hashCode()%16+"   "+"zzy".hashCode()%16+"   "+"sy".hashCode()%16);
        System.out.println(lover);//HashMap���Լ���toString
        //��Map���м�ֵ��ִ���������,˳����ɢ�б�Ĵ洢Ͱ��˳���й�
        lover.forEach((s1,s2)->System.out.println(s1+" loves "+s2));
        //��ֵ�ԵĲ���
        System.out.println(lover.get("hjx"));
        System.out.println(lover.get("zqq"));//����û�еĽ��᷵��null
        System.out.println(lover.getOrDefault("zqq","He has no lover"));//����û�еĽ��᷵���Լ��趨��Ĭ��ֵ
        System.out.println(lover.size());

        //��Mapת��Ϊ����Collection�Ӷ�ʵ�ּ����еķ���,ת�������ļ���Ҳ����ͼ,�����Ϳ���ʵ�ּ����еķ���
        //������ͼ��˵�����Խ���ɾ��Ԫ�أ������Ļ���ԭ����Map��Ӧ�ļ�ֵ��Ҳ�ᱻɾ�������ǲ������Ԫ�أ���������쳣
        //1.����Map.Entry������ɵ�Set��
        Set<Map.Entry<String,String>> set1 = lover.entrySet();
        Iterator it1 = set1.iterator();
        while(it1.hasNext())
        {
            System.out.println(it1.next());
        }
        System.out.println("------");
        //2.����ӳ�������м��ļ���ͼ
        Set<String> set2 = lover.keySet();
        Iterator it2 = set2.iterator();
        while(it2.hasNext())
        {
            System.out.println(it2.next());
        }
        System.out.println("------");
        //3.����ӳ��������ֵ��һ������ͼ
        Collection<String> col3 = lover.values();
        //col3.add("aaa");
        Iterator it3 = col3.iterator();
        it3.next();
        it3.remove();
        while(it3.hasNext())
        {
            System.out.println(it3.next());
        }
        System.out.println("------");
        System.out.println(lover);
        System.out.println("------");
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,2);
        map.put(1,3);
        System.out.println(map);



    }

}

