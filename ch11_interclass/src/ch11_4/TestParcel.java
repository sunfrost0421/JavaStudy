package ch11_4;

class Parcel4
{
    private class PContents implements Contents{
        private int i = 11;

        @Override
        public int Value() {
            return i;
        }
    }

    protected final class PDestination implements Destination
    {
        private String label;
        public PDestination(String label)
        {
            this.label = label;
        }
        @Override
        public String readLabel() {
            return label;
        }
    }

    public Contents pContents()
    {
        return new PContents();
    }
    public Destination pDestination(String s)
    {
        return new PDestination(s);
    }
}


public class TestParcel
{
    Parcel4 p = new Parcel4();
    Contents c = p.pContents();
    Destination d = p.pDestination("shanghai");

}
