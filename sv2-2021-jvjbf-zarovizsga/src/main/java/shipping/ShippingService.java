package shipping;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShippingService {
    private List<Transportable> packages = new ArrayList<>();

    public void addPackage(Transportable transportable) {
        packages.add(transportable);
    }

    public List<Transportable> getPackages() {
        return List.copyOf(packages);
    }

    public List<Transportable> collectItemsByBreakableAndWeight(boolean breakable, int weight) {
        return packages.stream()
                .filter(p -> p.isBreakable() == breakable && p.getWeight() >= weight)
                .toList();
    }

    public Map<String, Integer> collectTransportableByCountry() {
        return packages.stream()
                .collect(Collectors.toMap(
                        Transportable::getDestinationCountry,
                        transportable -> 1,
                        Integer::sum
                ));
    }

    public List<Transportable> sortInternationalPackagesByDistance() {
        return packages.stream()
                .filter(transportable -> transportable instanceof InternationalPackage)
                .sorted(Comparator.comparing(p -> ((InternationalPackage) p).getDistance()))
                .toList();
    }
}
