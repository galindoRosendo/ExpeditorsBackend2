package ttl.larku.shape.domain;

public class Rectangle extends Shape{

   private int width, height;

   public Rectangle(int width, int height, int x1, int y1) {
      this(width, height, x1, y1, "Black", true, 1);
   }

   public Rectangle(int width, int height, int x1, int y1, String color, boolean isDraggable, int lineThickness) {
      this.width = width;
      this.height = height;
   }

   public int getWidth() {
      return width;
   }

   public void setWidth(int width) {
      this.width = width;
   }

   public int getHeight() {
      return height;
   }

   public void setHeight(int height) {
      this.height = height;
   }


   //circumference - perimeter
   public double getPerimeter() {
      return 2 * width + 2 * height;
   }

   //area
   public double getArea() {
      return width * height;
   }

   public void draw() {
      System.out.println(STR."Rectangle::draw "); //with \{x1}, \{y1}, w, h: \{width}, \{height}");
   }
}
