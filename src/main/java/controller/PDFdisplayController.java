package controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.text.Text;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PDFdisplayController implements Initializable {
    @FXML
    private ImageView PDFimage;
    @FXML
    private Text PageNumber;

    private int pageNr = 0;
    private int totalPages = 0;
    private String path = "x";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadPdf(this.pageNr, this.path);
    }

    public void loadPdf(int page, String path) {
        try {
            PDDocument document = PDDocument.load(new File(path));
            this.totalPages = document.getNumberOfPages() - 1;
            document.close();

            PageNumber.setText("Pagina: " + (this.pageNr + 1) + "/" + (this.totalPages + 1));
            loadPage(page, path);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadPage(int page, String path) {
        try {
            Image image = convertToFxImage(pdfToImage(page, path));
            PDFimage.setImage(image);
        } catch (Exception e) {
            System.out.println("ERROR in loadPage");
            e.printStackTrace();
        }
    }

    public BufferedImage pdfToImage(int page, String path) {
        try (PDDocument document = PDDocument.load(new File(path))) {
            PDFRenderer pdfRenderer = new PDFRenderer(document);
            BufferedImage bim = pdfRenderer.renderImageWithDPI(page, 300, ImageType.RGB);
            document.close();
            return bim;
        } catch (IOException e) {
            System.err.println("Exception while trying to create pdf document - " + e);
        }
        System.out.println("pdfToImage null");
        return null;
    }

    public Image convertToFxImage(BufferedImage image) {
        WritableImage wr = null;
        if (image != null) {
            wr = new WritableImage(image.getWidth(), image.getHeight());
            PixelWriter pw = wr.getPixelWriter();
            for (int x = 0; x < image.getWidth(); x++) {
                for (int y = 0; y < image.getHeight(); y++) {
                    pw.setArgb(x, y, image.getRGB(x, y));
                }
            }
        }
        return new ImageView(wr).getImage();
    }

    public void nextButton(ActionEvent actionEvent) {
        if (pageNr != totalPages) {
            loadPage(this.pageNr + 1, this.path);
            pageNr += 1;
            PageNumber.setText("Pagina: " + (this.pageNr + 1) + "/" + (this.totalPages + 1));
        }
    }

    public void previousButton(ActionEvent actionEvent) {
        if (pageNr != 0) {
            loadPage(this.pageNr - 1, this.path);
            pageNr -= 1;
            PageNumber.setText("Pagina: " + (this.pageNr + 1) + "/" + (this.totalPages + 1));
        }
    }
}
