package MapTest;

import java.util.*;

public class HashMapTest
{
    public static void main(String[] args)
    {
        var lover = new HashMap<String,String>();

        lover.put("hjx","qrc");//添加键值对，左边是键，右边是值
        lover.put("zzy","ly");
        lover.put("sy","qyy");
        lover.containsKey("hjx");
        lover.replace("zzy", "LY");

        System.out.println("HASHCODE:   "+"hjx".hashCode()%16+"   "+"zzy".hashCode()%16+"   "+"sy".hashCode()%16);
        System.out.println(lover);//HashMap有自己的toString
        //对Map所有键值对执行这个动作,顺序由散列表的存储桶的顺序有关
        lover.forEach((s1,s2)->System.out.println(s1+" loves "+s2));
        //键值对的查找
        System.out.println(lover.get("hjx"));
        System.out.println(lover.get("zqq"));//对于没有的健会返回null
        System.out.println(lover.getOrDefault("zqq","He has no lover"));//对于没有的健会返回自己设定的默认值
        System.out.println(lover.size());

        //将Map转化为集合Collection从而实现集合中的方法,转换过来的集合也叫视图,这样就可以实现集合中的方法
        //对于视图来说，可以进行删除元素，这样的话，原来的Map相应的键值对也会被删除。但是不能添加元素，否则会抛异常
        //1.返回Map.Entry对象组成的Set集
        Set<Map.Entry<String,String>> set1 = lover.entrySet();
        Iterator it1 = set1.iterator();
        while(it1.hasNext())
        {
            System.out.println(it1.next());
        }
        System.out.println("------");
        //2.返回映射中所有键的集视图
        Set<String> set2 = lover.keySet();
        Iterator it2 = set2.iterator();
        while(it2.hasNext())
        {
            System.out.println(it2.next());
        }
        System.out.println("------");
        //3.返回映射中所有值的一个集视图
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

