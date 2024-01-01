package behavioral.template;

public abstract class DocumentConverter {
    public final void convertDocument() {
        readDocument();
        parseDocument();
        analyzeDocument();
        customizeConversion();
        writeDocument();
    }

    protected abstract void readDocument();
    protected abstract void parseDocument();
    protected abstract void analyzeDocument();
    protected abstract void customizeConversion();
    protected abstract void writeDocument();
}
