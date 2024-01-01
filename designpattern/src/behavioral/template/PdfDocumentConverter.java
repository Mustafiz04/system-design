package behavioral.template;

public class PdfDocumentConverter extends DocumentConverter {

    @Override
    protected void readDocument() {
        System.out.println("Reading PDF document");
    }

    @Override
    protected void parseDocument() {
        System.out.println("Parsing PDF document");
    }

    @Override
    protected void analyzeDocument() {
        System.out.println("Analyzing PDF document");
    }

    @Override
    protected void customizeConversion() {
        System.out.println("Customizing PDF conversion");
    }

    @Override
    protected void writeDocument() {
        System.out.println("Writing PDF document");
    }
}
