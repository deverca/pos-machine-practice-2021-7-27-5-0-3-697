package pos.machine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static pos.machine.ItemDataLoader.loadAllItemInfos;

public class PosMachine {

    public List<ItemInfo> generateProductDetails(String barcode) {

        return loadAllItemInfos().stream()
                .filter(itemInfo -> barcode.equalsIgnoreCase(itemInfo.getBarcode())).collect(Collectors.toList());
    }


    public int calculateQty(List<String> barcodes, String barcode) {

        return (int) barcodes.stream().filter(code -> code.equalsIgnoreCase(barcode)).count();


    }

    public double calculateSubTotal(double price, int quantity) {

        return price * quantity;
    }

    public double calculateTotal(List<Double> subTotals) {
        return subTotals.stream().mapToDouble(price -> price).sum();
    }

    public String generateReceiptDetails(int quantity, double subtotal, List<ItemInfo> productDetails) {
        return "Name: " + productDetails.get(0).getName() + ", Quantity: " + quantity
                + ", Unit price: " + productDetails.get(0).getPrice() + " (yuan), Subtotal: " + (int)subtotal + " (yuan)\n";

    }


    public String printReceipt(List<String> barcodes) {
        StringBuilder receipt = new StringBuilder("***<store earning no money>Receipt***\n");
        List<Double> subTotals = new ArrayList<>();
        List<String> uniqueBarcodes = new ArrayList<>();

        for (String barcode : barcodes) {
            List<ItemInfo> productDetails = generateProductDetails(barcode);
            int quantity = calculateQty(barcodes, barcode);
            double subTotal = calculateSubTotal(productDetails.get(0).getPrice(), quantity);

            if (!uniqueBarcodes.contains(barcode)) {
                receipt.append(generateReceiptDetails(quantity, subTotal, productDetails));
                subTotals.add(subTotal);
            }
            uniqueBarcodes.add(barcode);

        }

        receipt.append("----------------------\n");
        receipt.append("Total: ").append((int)calculateTotal(subTotals)).append(" (yuan)");
        receipt.append("\n**********************");

        return receipt.toString();

    }
}
