package view;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ViewTest
{
    public static void main(String[] args)
    {
        //利用已有元素，快速创建列表、集、映射。但元素不能为null否则抛异常,以下的集合不可以被修改
        List<String>  list = List.of("qrc","hjx","family");
        Set<String> set = Set.of("aaa","bbb","ccc");
        Map<String,Integer> map1 = Map.of("aaa",1,"bbb",2);
        Map<String,Integer> map2 = Map.ofEntries(Map.entry("aaa",1),Map.entry("bbb",2));
        //list.add("aaa");不可以修改


    }
}
