public enum Location {
    OPPOSITE_RAVINE_SLOPE("opposite slope of the ravine"),
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
