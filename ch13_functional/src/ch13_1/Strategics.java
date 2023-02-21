package ch13_1;



public class Strategics
{
    Strategy strategy;
    String  msg;
    Strategics(String msg)
    {
        strategy = new Soft();
        this.msg = msg;
    }
    void communicate(){
        System.out.println(strategy.approach(msg));
    }
    void changeStrategy(Strategy strategy)
    {
        this.strategy = strategy;
    }

    public static void main(String[] args) {
        Strategy[] strategies = {
                new Strategy(){
                    @Override
                    public String approach(String msg) {
                        return msg.toUpperCase() + "!";
                    }
                },
                msg -> msg.substring(0,5),
                Unrelated::twice
        };
        Strategics s = new Strategics("Hello there");
        s.communicate();
        for(Strategy ss:strategies)
        {
            s.changeStrategy(ss);
            s.communicate();
        }
    }
}
