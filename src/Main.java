
public class Main {
    private static final String coordinateTemplate = "{ x: %f, y: %f} ";
    public static void main(String[] args) {

        // max array size
        final int  MaxSize = 5;

        // real array size
        int n =  (int)(Math.random() * MaxSize);

        Coordinate[] coordinates = new Coordinate[n];

        for (int i = 0; i < n; i++) {
            double x = Math.random();
            double y = Math.sin(x);

            coordinates[i] = new Coordinate(x,y);
        }

        printAll(coordinates);

        quickSort(coordinates, 0, coordinates.length - 1);

        printAll(coordinates);

    }

    private static void quickSort(Coordinate[] coordinates, int i, int i1) {
        // if array is empty
        if (coordinates.length == 0) {
            return;
        }

        // if similar, that means array is already sorted
        if (i >= i1) {
            return;
        }

        // find pivot for current array
        int j = partition(coordinates, i, i1);
        quickSort(coordinates, i, j - 1);
        quickSort(coordinates, j + 1, i1);
    }

    private static int partition(Coordinate[] coordinates, int i, int i1) {

        // set pivot as default left element
        Coordinate pivot = coordinates[i1];
        int j = i;

        // compare each element with pivot and set less elements to left side and greater to right
        for (int k = i; k < i1; k++) {
            if (coordinates[k].getX() < pivot.getX()) {
                Coordinate temp = coordinates[j];
                coordinates[j] = coordinates[k];
                coordinates[k] = temp;
                // if swapped, increment j (mean that pivot moved to right side)
                j++;
            }
        }
        Coordinate temp = coordinates[j];
        coordinates[j] = coordinates[i1];
        coordinates[i1] = temp;
        return j;
    }

    private static void printAll(Coordinate[] coordinates) {
        for (int i = 0; i < coordinates.length; i++) {
            System.out.printf(coordinateTemplate, coordinates[i].getX(), coordinates[i].getY());
        }
        System.out.println();
    }
}