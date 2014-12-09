import com.sabre.fltsked.extensions.modules.profit.DistanceRevenueAllocator.Leg;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

import static java.lang.Math.sqrt;
import static org.junit.Assert.assertEquals;

public class DistanceRevenueAllocatorImplTest
{

    @Before
    public void setUp() throws Exception
    {

    }

    @Test
    public void testGetProrateRatios() throws Exception
    {
        final Leg leg1 = leg(100);
        final Leg leg2 = leg(250);

        final DistanceRevenueAllocatorImpl testedObj = new DistanceRevenueAllocatorImpl();
        final Map<Leg, Float> result = testedObj.getProrateRatios(Arrays.asList(leg1, leg2));

        assertEquals((sqrt(100) / (sqrt(100) + sqrt(250))), result.get(leg1), 0.0001);
        assertEquals((sqrt(250) / (sqrt(100) + sqrt(250))), result.get(leg2), 0.0001);
    }

    static Leg leg(final int distance)
    {
        return new Leg() {
            @Override
            public int distance() {
                return distance;
            }
        };
    }
}