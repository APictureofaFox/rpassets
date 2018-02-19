package rpassets.core.model.numenera;

public class Distance {
    enum DistanceType {
        IMMEDIATE, SHORT, LONG, OTHER
    }

    private final DistanceType type;
    private final double distance;

    private Distance(DistanceType type, double distance) {
        this.type = type;
        this.distance = distance;
    }

    public static Distance immediateRange() {
        return new Distance(DistanceType.IMMEDIATE, 1.5);
    }

    public static Distance shortRange() {
        return new Distance(DistanceType.SHORT, 15);
    }

    public static Distance longRange() {
        return new Distance(DistanceType.LONG, 30);
    }

    public static Distance customRange(double distance) {
        return new Distance(DistanceType.OTHER, distance);
    }

    @Override
    public String toString() {
        switch (type) {
            case IMMEDIATE: return "immediate";
            case SHORT: return "short";
            case LONG: return "long";
            default: return distance + " m";
        }
    }
}
