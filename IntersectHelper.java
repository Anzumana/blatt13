import java.awt.Point;
/*
* Wenn wir uns die Klassen Rentange Circle IShape und IntersectHelper anschauen stellt man fest , das alle berechnungen zum 
* Prüfen ob sich die geometrischen Objekte berühren sehr elegant in die IntersectHelper ausgelagert wurden.
* Die Methoden werden überlagert indem wir für die selbe Methode verschiedene Paramterlisten festlegen.
* Damit können wir immer die  intersect methode auf unseren Objekten aufrufen und der rechner übernimmt welche 
* Methode es genau sein muss.
* Vor dem Hintergrund der Objektorientierung finde ich diese lösung sehr elegant da wir genau wissen 
* wo alle methoden zur Berechnung direkt in einer Klasse liegen.
* Wenn wir die implementierung in die jeweiligen Klassen gelegt hätten wäre dies auch möglich jedoch würde dies das 
* hinzufügen weiterer geometrischer Gebilder sehr umständlich machen. Da wir dann in jede unsere vorher
* vorhandenen Objekte gehen müssten um auch nur 1 neues hinzuzufügen.
* Der Arbeitsaufwand würde sich alles immer erhöhen wenn wir auf mehr als den aktuellen geometrischen Formen arbeiten wollen.
*/
public class IntersectHelper {	
	public static boolean intersect(Point a, Rectangle b) {
		if(a.x > b.x && a.x < b.x + b.width && 
		   a.y > b.y && a.y < b.y + b.height) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean intersect(Point a, Circle b) {
		double distSquared = (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
		if(distSquared <= b.radius * b.radius) {
			return true;
		} else {
			return false;
		}
	}
		
	public static boolean intersect(Rectangle a, Rectangle b) {
		double centerDistX = Math.abs((a.x + 0.5 * a.width) - (b.x + 0.5 * b.width));
		if(centerDistX > 0.5 * a.width + 0.5 * b.width) {
			return false;
		}

		double centerDistY = Math.abs((a.y + 0.5 * a.height) - (b.y + 0.5 * b.height));
		if(centerDistY > 0.5 * a.height + 0.5 * b.height) {
			return false;
		}
		
		return true;
	}
	
	public static boolean intersect(Rectangle a, Circle b) {
		Rectangle extendedRect = new Rectangle(
			a.x - b.radius, 
			a.y - b.radius, 
			a.width + 2 * b.radius, 
			a.height + 2 * b.radius);
		return intersect(new Point((int)b.x, (int)b.y), extendedRect);
	}
	
	public static boolean intersect(Circle a, Circle b) {
		double distSquared = (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
		if(distSquared <= (a.radius + b.radius) * (a.radius + b.radius)) {
			return true;
		} else {
			return false;
		}
	}
	
}
