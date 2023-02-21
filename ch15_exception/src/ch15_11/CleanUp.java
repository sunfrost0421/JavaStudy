package ch15_11;

public class CleanUp {
    public static void main(String[] args) {
        try{
            InputFile inputFile = new InputFile("");
            try{
                String s;
                int i = 1;
                while((s = inputFile.getLine())!=null)
                    ;
            }catch (Exception e){
                e.printStackTrace(System.out);
            }finally {
                inputFile.dispose();
            }
        }catch(Exception e){
            System.out.println("InputFile construction failed");
        }
    }
}
