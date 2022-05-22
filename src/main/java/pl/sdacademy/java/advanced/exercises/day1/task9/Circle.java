package pl.sdacademy.java.advanced.exercises.day1.task9;

public class Circle implements Movable{
    private Point2D center;
    private Point2D point;

    public Circle(Point2D center, Point2D point) {
        this.center = center;
        this.point = point;
    }

    public Point2D getCenter() {
        return center;
    }

    public Point2D getPoint() {
        return point;
    }

    //sqrt((centerX - pointX)^2 + (centerY - pointY)^2)
    public double getRadius() {
        return Math.sqrt(Math.pow(center.getX() - point.getX(), 2) + Math.pow(center.getY() - point.getY(), 2));
    }

    public double getPerimeter() {
        return 2 * Math.PI * getRadius();
    }

    public double getArea() {
        return Math.PI * Math.pow(getRadius(), 2);
    }

    @Override
    public void move(MoveDirection moveDirection) {
//        center.setX(center.getX() + moveDirection.getX());
//        center.setY(center.getY() + moveDirection.getY());
//        point.setX(point.getX() + moveDirection.getX());
//        point.setY(point.getY() + moveDirection.getY());
        center.move(moveDirection);
        point.move(moveDirection);
    }
}
