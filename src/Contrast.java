import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Contrast {
    public Contrast() {
        try {
            System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
            Mat source = Imgcodecs.imread("grayscale.jpg");
            Mat destination = new Mat(source.rows(), source.cols(), source.type());
            Imgproc.equalizeHist(source, destination);
            Imgcodecs.imwrite("contrast.jpg", destination);
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Contrast contrast = new Contrast();
    }
}
