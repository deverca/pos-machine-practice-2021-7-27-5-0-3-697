package pos.machine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static pos.machine.ItemDataLoader.loadAllItemInfos;

public class PosMachine {

    public List<ItemInfo> generateProductDetails(String barcode) {

        return loadAllItemInfos().stream()
                .filter(itemInfo -> itemInfo.getBarcode().equalsIgnoreCase(barcode)).collect(Collectors.toList());

    }

    public int calculateQty(List<ItemInfo> productDetails) {

        return productDetails.size();
    }

    public double calculateSubTotal(double price, int quantity) {

        return price * quantity;
    }

    public double calculateTotal(List<Double> subTotals) {
        return subTotals.stream().mapToDouble(a -> a).sum();
    }

    public String generateReceiptDetails(int quantity, double subtotal, List<ItemInfo> productDetails) {
        return "Name: " + productDetails.get(0).getName() + ", Quantity: " + quantity
                + ", Unit price: " + productDetails.get(0).getPrice() + "(yuan), Subtotal: " + subtotal + "(yuan)\n";

    }


    public String printReceipt(List<String> barcodes) {
        StringBuilder receipt = new StringBuilder("***<store earning no money>Receipt ***\n");
        List<Double> subTotals = new ArrayList<>();
        for (String barcode : barcodes) {
            List<ItemInfo> productDetails = generateProductDetails(barcode);
            int quantity = calculateQty(productDetails);
            double subTotal = calculateSubTotal(productDetails.get(0).getPrice(), quantity);
            subTotals.add(subTotal);
            receipt.append(generateReceiptDetails(quantity, subTotal, productDetails));
        }
        receipt.append("Total: ").append(calculateTotal(subTotals)).append(" (yuan)");
        return receipt.toString();
    }
}
