package Stream3Optional;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

//Optional���������ֲ�����filter(��������)��map(����)��flatMap(����)
/*
* 1.Optional.filter(Predicate),���Predicate����true���򷵻ظ�Optional��������ת��ΪOptional.empty
*   ע�⣺Stream.filter(Predicate) ֻ��������Predicate�Ľ��Ϊtrue��Ԫ��
* 2.Optional.map(Function)�����������Optional��Ϊ�գ�ִ��Function,����Optional�����Ķ��󣬷��صĽ���Զ������Optional�У�
*   ���򷵻أ�Optional.empty��
* 3.Optional.flatMap()�����������Optional��Ϊ�գ�ִ��Function,����Optional�����Ķ��󣬽����Ҫ�ֶ������Optional�У�
*   ���򷵻أ�Optional.empty��
* */
public class OptionalControl
{
    public static void main(String[] args)
    {
        //Optional.filter(��������),�����������������򷵻ظ�Optional��������ת��ΪOptional.empty
        String[] s1 = {"aaa","bbb","ccc"};
        System.out.println(Arrays.stream(s1).findFirst().filter(x->x == "bbb"));
        Arrays.stream(s1).map(w->Optional.ofNullable(w)).map(x->x.filter(a->a=="bbb")).forEach(System.out::println);
        System.out.println("==========");
        Arrays.stream(s1).filter(a->a=="bbb").forEach(System.out::println);
        System.out.println(Arrays.stream(s1).findFirst().map(a->a+"mmm"));
        System.out.println(Arrays.stream(s1).findFirst().flatMap(a->Optional.ofNullable(a+"mmm")));
        //Optional.map(����)�����������Optional��Ϊ�գ�Optional.empty����Optionalִ�в�����
        //���OptionalΪ�գ�Optional.empty������ִ�в�����ֱ��ͨ��
        //Optional.map(����)��ִ�в���ʱ��map���Ƚ�Optional�������Ԫ��ִ����������ڰ�װΪOptional
        String[] s2 = {"12","","23","45"};
        for(int i = 0;i<=s2.length;i++)
        {
            System.out.println(
                    Arrays.stream(s2).skip(i).findFirst().map(s->s.replace("2","9"))
            );
        }

        //�����ϣ��ִ����������Զ����ΪOptional�������Լ�д�������ΪOptional
        //�������Optional.flatMap(),�������ִ�в���ǰ��������ִ�����������Ҫ�ֶ����
        for(int i = 0;i<=s2.length;i++)
        {
            System.out.println(
                    Arrays.stream(s2).skip(i).findFirst()
                            .flatMap(s-> Optional.of(s.replace("2","9")))
            );
        }

        //�õ�Optional������ɵ���
        System.out.println("=== Optional������ɵ����İ�װ�ͽ�� ===");
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
                .peek(s->System.out.print("��ʼ��"+s+"  "))
                .map(s->Optional.ofNullable(s)).limit(10)
                .peek(s->System.out.print("��װ��"+s+"  "))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(System.out::println);

    }
}
