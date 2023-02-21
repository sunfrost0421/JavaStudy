package ch11_8;

public class GreenhouseController
{
    public static void main(String[] args) {
        GreenhouseControls gc = new GreenhouseControls();
        gc.addEvent(gc.new Bell(900));
        Event[] events = {
                gc.new LightOn(200),
                gc.new LightOff(400)
        };
        gc.addEvent(gc.new Restart(2000, events));
        gc.addEvent(new GreenhouseControls.Terminate(5000));
        gc.run();
    }
}
