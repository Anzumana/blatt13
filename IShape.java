/*
 * Schauen wir uns die erste intersects methode an.
 * Der Grund warum diese etwas komisch wirkst liegt in dem Unterschied zwischen Static Type und Dynamic Type.
 * Unser IShape Object ist ein Static Type hier IShape.
 * Diese object kann bei Runtime jedoch alle Objecte sein die wir als IShape zulassen.
 * Bei uns kann es hier ein Rectangle oder ein Circle sein. Beide sind jedoch möglich.
 * Um welchen von beiden es sich handelt kann die Java Runtime jedoch erst zur Laufzeit feststellen.
 * Daher können wir nicht vorher schon genau auswählen welche intersets methode für das IShape Object benutzt werden soll.
 *
 */
public interface IShape {
	boolean intersects(IShape other);
	boolean intersects(Rectangle other);
	boolean intersects(Circle other);
}
