package view;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ViewTest
{
    public static void main(String[] args)
    {
        //��������Ԫ�أ����ٴ����б�����ӳ�䡣��Ԫ�ز���Ϊnull�������쳣,���µļ��ϲ����Ա��޸�
        List<String>  list = List.of("qrc","hjx","family");
        Set<String> set = Set.of("aaa","bbb","ccc");
        Map<String,Integer> map1 = Map.of("aaa",1,"bbb",2);
        Map<String,Integer> map2 = Map.ofEntries(Map.entry("aaa",1),Map.entry("bbb",2));
        //list.add("aaa");�������޸�


    }
}
