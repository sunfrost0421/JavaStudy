package appendix_C;

public class Groundhog
{
    protected int number;
    public Groundhog(int n)
    {
        this.number = n;
    }

    @Override
    public String toString() {
        return "Groundhog #" + number;
    }
}
