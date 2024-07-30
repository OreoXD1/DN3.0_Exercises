
// TestFactoryMethod.java
public class TestFactoryMethod {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();

        WordDocument wordDoc = (WordDocument) wordFactory.createDocument();
        PdfDocument pdfDoc = (PdfDocument) pdfFactory.createDocument();
        ExcelDocument excelDoc = (ExcelDocument) excelFactory.createDocument();

        wordDoc.create();
        pdfDoc.create();
        excelDoc.create();
    }
}
