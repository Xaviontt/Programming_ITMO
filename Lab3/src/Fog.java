public class Fog extends WeatherCondition implements FogChanges {

    public Fog(String weatherCondition) {
        super(weatherCondition);
    }


    @Override
    public void becomeClearer() {
        System.out.println(super.getWeatherCondition() + " become clearer");
    }

    @Override
    public void clearAway() {
        System.out.println(super.getWeatherCondition() + " cleared away");
    }
}
