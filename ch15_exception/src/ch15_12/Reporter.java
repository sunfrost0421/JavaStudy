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
                //����ʵ���˽ӿ�AutoCloseable�����ʵ��
                First f = new First();
                Second se = new Second();
                ){
            //�������ݣ�try����������Զ�����ʵ����close()
        }catch (Exception e){

        }
    }
}
