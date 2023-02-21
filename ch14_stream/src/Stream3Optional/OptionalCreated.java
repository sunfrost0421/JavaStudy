package Stream3Optional;

import java.util.Optional;

//当访问流中的数据时，空的流往往会抛异常，这个时候需要optional对象来存储
//以下流操作会返回Optional对象：findFirst()、findAny()、max()、min()......
/*有三种自行生成Optional的静态方法：
* 1.empty():返回Optional.empty
* 2.of(v):将v包装在Optional中
* 3.ofNullable(v):如果v为null,则返回Optional.empty;否则，将v包装在Optional中
*
* 有4种读取Optional值的便捷实例函数，这些函数不需要检查该Optional是不是有东西再访问：
* 1.ifPresent(Consumer):如果该Optional有值，则将值传入Consumer中，否则什么都不做
* 2.orElse(other):如果该Optional有值，返回这个对象，否则返回other
* 3.orElseGet(Supplier):如果该Optional有值，返回这个对象，否则返回Supplier创建的对象
* 4.orElseThrow(Supplier):如果该Optional有值，返回这个对象，否则返回Supplier创建的异常
*/
public class OptionalCreated
{
    static void test(String testName,Optional<String> opt)
    {
        System.out.println(" === "+testName+" === ");
        System.out.println(opt.orElse(null));
    }
    public static void main(String[] args)
    {
        //方法一：建立空的Optional,不代表null
        System.out.println(Optional.empty());
        OptionalCreated.test("empty()",Optional.empty());
        //方法二：将某个对象包装在Optional中，如果该对象是null，则会抛异常
        OptionalCreated.test("of(值)",Optional.of("success"));
        try {
            OptionalCreated.test("of(值)",Optional.of(null));
        } catch (Exception e) {
            System.out.println(e);
        }
        //方法三：将某个对象包装在Optional中，如果该对象是null，则返回Optional.empty。
        OptionalCreated.test("ofNullable(值)",Optional.ofNullable("hello"));


    }
}
