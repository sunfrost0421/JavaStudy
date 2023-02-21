package appendix_C;

import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SpringDetector
{
    public static <T extends Groundhog> void detectSpring(Class<T> type)
    {
        try{
            Constructor<T> ghog = type.getConstructor(int.class);
            Map<Groundhog, Prediction> map = IntStream.range(0, 10).mapToObj(
                    i->{
                        try{
                            return ghog.newInstance(i);
                        }catch(Exception e)
                        {
                            throw new RuntimeException(e);
                        }
                    }
            ).collect(Collectors.toMap(Function.identity(), gh->new Prediction()));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
