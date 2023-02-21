package ch13_1;

public class Soft implements Strategy
{
    @Override
    public String approach(String msg) {
        return msg.toLowerCase() + "?";
    }
}
