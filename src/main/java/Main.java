import pos.machine.PosMachine;

import static pos.machine.ItemDataLoader.loadBarcodes;


public class Main {
    public static void main(String[] args) {
        PosMachine posMachine = new PosMachine();
        System.out.println(posMachine.printReceipt(loadBarcodes()));
    }
}
