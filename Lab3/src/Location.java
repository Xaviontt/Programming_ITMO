public enum Location {
    OPPOSITE_SLOPE("opposite slope"),
    SURFACE("surface"),
    LOOSE_GROUND("loose ground");

    String locationName;

    Location(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationName() {
        return locationName;
    }
}
