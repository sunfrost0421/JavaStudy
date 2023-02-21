package ch15_6;

import java.util.Arrays;

class DynamicFieldsException extends Exception{}

public class DynamicFields {
    private Object[][] fields;
    public DynamicFields(int init){
        fields = new Object[init][2];
        for(int i=1;i<init;i++)
        {
            fields[i] = new Object[]{null,null};
        }
    }

    @Override
    public String toString() {
        return "DynamicFields{" +
                "fields=" + Arrays.deepToString(fields) +
                '}';
    }
    private int hasFiled(String id)
    {
        for(int i=0;i<fields.length;i++)
        {
            if(id.equals(fields[i][0]))
                return i;
        }
        return -1;
    }
    private int getFieldNumber(String id) throws NoSuchFieldException
    {
        int fieldNum = hasFiled(id);
        if(fieldNum == -1)
            throw new NoSuchFieldException();
        return fieldNum;
    }
    private int makeField(String id)
    {
        for(int i=0;i<fields.length;i++){
            if(fields[i][0]==null){
                fields[i][0] = id;
                return i;
            }
        }
        Object[][] tmp = new Object[fields.length+1][2];
        for(int i=0;i<fields.length;i++)
            tmp[i] = fields[i];
        for(int i=fields.length;i<tmp.length;i++)
            tmp[i] = new Object[]{null,null};
        fields = tmp;
        return makeField(id);
    }
    public Object getField(String id) throws NoSuchFieldException
    {
        return fields[getFieldNumber(id)][1];
    }
    public Object setField(String id,Object value) throws DynamicFieldsException
    {
        if(value == null){
            DynamicFieldsException dfe =
                    new DynamicFieldsException();
            dfe.initCause(new NullPointerException());
            throw dfe;
        }
        int fieldNum = hasFiled(id);
        if(fieldNum==-1)
        {
            fieldNum = makeField(id);
        }
        Object result = null;
        try{
            result = getField(id);
        }catch(NoSuchFieldException e){
            throw new RuntimeException(e);
        }
        fields[fieldNum][1] = value;
        return result;
    }

    public static void main(String[] args) {
        DynamicFields df = new DynamicFields(3);
        System.out.println(df);
        try{
            df.setField("d","A value of d");
            df.setField("number1",47);
            df.setField("number2",48);
            System.out.println(df);
            Object obj1 = df.setField("d","A new value of d");
            Object obj2 = df.setField("number3",11);
            System.out.println("obj1:"+obj1+"    obj2:"+obj2);
            System.out.println("df"+df);
            System.out.println(df.getField("d"));
            Object field = df.setField("d",null);
        }catch (NoSuchFieldException | DynamicFieldsException e){
            e.printStackTrace(System.out);
        }
    }
}
