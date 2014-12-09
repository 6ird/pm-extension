import com.sabre.fltsked.extensions.modules.profit.DistanceRevenueAllocator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DistanceRevenueAllocatorImpl implements DistanceRevenueAllocator
{
    @Override
    public Map<Leg, Float> getProrateRatios(List<Leg> legs)
    {
        final Map<Leg, Float> ratios = new HashMap<Leg, Float>();
        float sum = 0;
        for (Leg leg : legs)
        {
            final float dist = (float) Math.sqrt(leg.distance());
            ratios.put(leg, dist);
            sum += dist;
        }
        for (Leg leg : ratios.keySet())
        {
            final Float dist = ratios.get(leg);
            ratios.put(leg, dist / sum);
        }
        return ratios;
    }
}