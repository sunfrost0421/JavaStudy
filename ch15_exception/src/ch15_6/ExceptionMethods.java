package ch15_6;

public class ExceptionMethods {
    public static void main(String[] args) {
        try{
            throw new Exception("My exception");
        }catch(Exception e){
            System.out.println("Caught it");
            System.out.println("getMessage():"+e.getMessage());
            System.out.println("e.getLocalizedMessage():"+e.getLocalizedMessage());
            System.out.println("toString():"+e);
            System.out.println("printStackTrace():");
            e.printStackTrace(System.out);
            System.out.println("getStackTrace()");
        }
    }
}
