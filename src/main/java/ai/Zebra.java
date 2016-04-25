package ai;
/*
    Zebra printer code
 */
import javax.print.*;
import javax.print.attribute.PrintServiceAttribute;
import javax.print.attribute.standard.PrinterName;

/**
 * @author Vani Li
 */
public class Zebra {
    public static void main(String args[]){
            new Zebra().testZebra();
    }

    public void testZebra() {

        try {
            PrintService psZebra = null;
            String sPrinterName = null;
            PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
            for (int i = 0; i < services.length; i++) {
                PrintServiceAttribute attr = services[i].getAttribute(PrinterName.class);
                sPrinterName = ((PrinterName)attr).getValue();
                //set zebra printer name
                if (sPrinterName.toLowerCase().indexOf("zdesigner") >= 0) {
                    psZebra = services[i];
                    break;
                }
            }
            if (psZebra == null) {
                System.out.println("Zebra printer is not found.");
                return;
            }
            System.out.println("Found printer: " + sPrinterName);
            DocPrintJob job = psZebra.createPrintJob();

            //String s = "^XA^FO5,40^BY3^B3,,30^FD123ABC^XZ"; // good
            String s = "^XA\n^FO5,40^BY3^B3,,\n30^FD123ABC\n^XZ"; // '\n' does not hurt
            byte[] by = s.getBytes();
            DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
// MIME type = "application/octet-stream",
// print data representation class name = "[B" (byte array).
            Doc doc = new SimpleDoc(by, flavor, null);
            job.print(doc, null);
        } catch (PrintException e) {
            e.printStackTrace();
        }
    } // testZebra()
}
