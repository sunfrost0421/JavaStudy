package ch15_13;

class A extends Exception{}
class B extends A{}

public class CatchException {
    public static void main(String[] args) {
        try{
            throw new B();
        }catch (B e){
            System.out.println("catch B");
        }catch(A e){
            System.out.println("catch A");
        }
        try{
            throw new B();
        }catch(A e){
            System.out.println("catch A");
        }
//        catch (B e){
//            System.out.println("catch B");
//        }
    }
}
