package Stream3Optional;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

//Optional上面有三种操作：filter(过滤条件)、map(操作)、flatMap(操作)
/*
* 1.Optional.filter(Predicate),如果Predicate返回true，则返回该Optional，否则将其转化为Optional.empty
*   注意：Stream.filter(Predicate) 只保留流中Predicate的结果为true的元素
* 2.Optional.map(Function)，如果会对这个Optional不为空，执行Function,传入Optional包含的对象，返回的结果自动打包到Optional中；
*   否则返回（Optional.empty）
* 3.Optional.flatMap()，如果会对这个Optional不为空，执行Function,传入Optional包含的对象，结果需要手动打包到Optional中，
*   否则返回（Optional.empty）
* */
public class OptionalControl
{
    public static void main(String[] args)
    {
        //Optional.filter(过滤条件),如果满足过滤条件，则返回该Optional，否则将其转化为Optional.empty
        String[] s1 = {"aaa","bbb","ccc"};
        System.out.println(Arrays.stream(s1).findFirst().filter(x->x == "bbb"));
        Arrays.stream(s1).map(w->Optional.ofNullable(w)).map(x->x.filter(a->a=="bbb")).forEach(System.out::println);
        System.out.println("==========");
        Arrays.stream(s1).filter(a->a=="bbb").forEach(System.out::println);
        System.out.println(Arrays.stream(s1).findFirst().map(a->a+"mmm"));
        System.out.println(Arrays.stream(s1).findFirst().flatMap(a->Optional.ofNullable(a+"mmm")));
        //Optional.map(操作)，如果会对这个Optional不为空（Optional.empty），Optional执行操作。
        //如果Optional为空（Optional.empty），则不执行操作，直接通过
        //Optional.map(操作)在执行操作时，map会先将Optional解包，对元素执行完操作后，在包装为Optional
        String[] s2 = {"12","","23","45"};
        for(int i = 0;i<=s2.length;i++)
        {
            System.out.println(
                    Arrays.stream(s2).skip(i).findFirst().map(s->s.replace("2","9"))
            );
        }

        //如果不希望执行完操作后自动打包为Optional而是想自己写函数打包为Optional
        //则可以用Optional.flatMap(),这个函数执行操作前会解包，但执行完操作后需要手动打包
        for(int i = 0;i<=s2.length;i++)
        {
            System.out.println(
                    Arrays.stream(s2).skip(i).findFirst()
                            .flatMap(s-> Optional.of(s.replace("2","9")))
            );
        }

        //得到Optional对象组成的流
        System.out.println("=== Optional对象组成的流的包装和解包 ===");
        Random rand = new Random(47);
        Stream.generate(
                ()->{
                    switch (rand.nextInt(4)){
                        case 1: return 1+"aaa";
                        case 2: return 2+"bbb";
                        default: return null;
                    }
                }
        )
                .peek(s->System.out.print("初始流"+s+"  "))
                .map(s->Optional.ofNullable(s)).limit(10)
                .peek(s->System.out.print("包装流"+s+"  "))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(System.out::println);

    }
}
