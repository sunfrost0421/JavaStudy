package Stream3Optional;

import java.util.Optional;

//���������е�����ʱ���յ������������쳣�����ʱ����Ҫoptional�������洢
//�����������᷵��Optional����findFirst()��findAny()��max()��min()......
/*��������������Optional�ľ�̬������
* 1.empty():����Optional.empty
* 2.of(v):��v��װ��Optional��
* 3.ofNullable(v):���vΪnull,�򷵻�Optional.empty;���򣬽�v��װ��Optional��
*
* ��4�ֶ�ȡOptionalֵ�ı��ʵ����������Щ��������Ҫ����Optional�ǲ����ж����ٷ��ʣ�
* 1.ifPresent(Consumer):�����Optional��ֵ����ֵ����Consumer�У�����ʲô������
* 2.orElse(other):�����Optional��ֵ������������󣬷��򷵻�other
* 3.orElseGet(Supplier):�����Optional��ֵ������������󣬷��򷵻�Supplier�����Ķ���
* 4.orElseThrow(Supplier):�����Optional��ֵ������������󣬷��򷵻�Supplier�������쳣
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
        //����һ�������յ�Optional,������null
        System.out.println(Optional.empty());
        OptionalCreated.test("empty()",Optional.empty());
        //����������ĳ�������װ��Optional�У�����ö�����null��������쳣
        OptionalCreated.test("of(ֵ)",Optional.of("success"));
        try {
            OptionalCreated.test("of(ֵ)",Optional.of(null));
        } catch (Exception e) {
            System.out.println(e);
        }
        //����������ĳ�������װ��Optional�У�����ö�����null���򷵻�Optional.empty��
        OptionalCreated.test("ofNullable(ֵ)",Optional.ofNullable("hello"));


    }
}
