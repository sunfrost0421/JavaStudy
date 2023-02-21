package ch15_12;

public class Reporter implements AutoCloseable{
    String name = getClass().getSimpleName();
    Reporter(){
        System.out.println("Creating "+name);
    }
    @Override
    public void close() throws Exception {
        System.out.println("Closing "+name);
    }
}
class First extends Reporter{};
class Second extends Reporter{};

class Test{
    public static void main(String[] args) {
        try(
                //构造实现了接口AutoCloseable的类的实例
                First f = new First();
                Second se = new Second();
                ){
            //处理内容，try块运行完后自动调用实例的close()
        }catch (Exception e){

        }
    }
}
