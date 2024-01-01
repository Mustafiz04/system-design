package behavioral.template;

public class WordDocumentConverter extends DocumentConverter {
    @Override
    protected void readDocument() {
        System.out.println("Reading Word document");
    }

    @Override
    protected void parseDocument() {
        System.out.println("Parsing Word document");
    }

    @Override
    protected void analyzeDocument() {
        System.out.println("Analayze word document");
    }

    @Override
    protected void customizeConversion() {
        System.out.println("Customize word conversion");
    }

    @Override
    protected void writeDocument() {
        System.out.println("Write word document");
    }
}
