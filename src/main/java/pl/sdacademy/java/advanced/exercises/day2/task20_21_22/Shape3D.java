package pl.sdacademy.java.advanced.exercises.day2.task20_21_22;

public abstract class Shape3D extends Shape implements Fillable{
    abstract double calculateVolume();

    @Override
    public int fill(double volume) {
        double maxVolume = calculateVolume();
        if(maxVolume == volume) {
            return 0;
        } else if(maxVolume >= volume) {
            return -1;
        }
        return 1;
    }
}
