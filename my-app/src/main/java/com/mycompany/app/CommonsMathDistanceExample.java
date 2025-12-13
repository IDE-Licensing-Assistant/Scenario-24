
package com.mycompany.app;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

public class CommonsMathDistanceExample {
    public static void main(String[] args) {
        // Create two 2D points as vectors
        Vector2D v1 = new Vector2D(1.0, 2.0);
        Vector2D v2 = new Vector2D(4.0, 6.0);

        // Compute distance
        double distance = v1.distance(v2);

        System.out.println("Distance (Commons Math): " + distance);
    }
}
