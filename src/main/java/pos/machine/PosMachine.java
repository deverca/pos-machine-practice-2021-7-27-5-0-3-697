package pos.machine;

import java.util.List;
import java.util.stream.Collectors;

import static pos.machine.ItemDataLoader.loadAllItemInfos;

public class PosMachine {

    public List<ItemInfo> generateProductDetails(String barcode){

        return loadAllItemInfos().stream()
                .filter(itemInfo -> itemInfo.getBarcode().equalsIgnoreCase(barcode)).collect(Collectors.toList());

    }

    public int calculateQty(List<ItemInfo> productDetails){

        return productDetails.size();
    }

    public double calculateSubTotal(double price, int quantity){

        return price * quantity;
    }
    public double calculateTotal(List<Double> subTotals){
        return subTotals.stream().mapToDouble(a->a).sum();
    }


    public String printReceipt(List<String> barcodes) {

     return null;
    }
}
