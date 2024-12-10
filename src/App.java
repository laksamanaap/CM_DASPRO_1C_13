import java.util.Scanner;

// class Item {
//     String name;
//     String category;
//     int stock;

//     Item(String name, String category, int stock) {
//         this.name = name;
//         this.category = category;
//         this.stock = stock;
//     }
// }

// items[itemID][0] = name
// items[itemID][1] = category
// items[itemID][2] = stock

public class App {

    static final Scanner Laksa13 = new Scanner(System.in);
    static Boolean status = true;

    static void menus() {
        System.out.println("==== MENU INVENTORI KAFE ====");
        System.out.println("1. Tampilkan Inventori");
        System.out.println("2. Tambah Stok Untuk Item Yang Ada");
        System.out.println("3. Tambah Item Baru");
        System.out.println("4. Keluar");
        System.out.print("Pilih Menu : ");
    }

    static void backToMenu() {
        System.out.println();
        System.out.println("Tekan enter untuk kembali ke menu...");
        Laksa13.nextLine();
        Laksa13.nextLine();
    }

    static void displayData(String[][] items) {
        System.out.println("==== DATA INVENTORI ====");
        System.out.println();
        System.out.printf("| %-4s | %-15s | %-10s | %4s |%n", "NO", "NAMA ITEM", "KATEGORI", "STOK");
        System.out.println("---------------------------------------------");

        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < 1; j++) {
                System.out.printf("| %-4d | %-15s | %-10s | %4s |%n", i + 1, items[i][0], items[i][1], items[i][2]);
            }
        }

    }

    static String[][] addStockData(String[][] items) {

        if (items.length == 0) {
            System.out.println("Tidak ada item dalam inventori!, Silahkan tambah data item baru");
            return items;
        }

        displayData(items);
        System.out.println();

        System.out.print("Masukkan nomor item: ");
        int itemID = Laksa13.nextInt() - 1;
        while (itemID < 0 || itemID >= items.length) {
            System.out.println("Nomor item tidak valid! Silakan coba lagi.");
            System.out.print("Masukkan nomor item: ");
            itemID = Laksa13.nextInt() - 1;
        }

        System.out.print("Masukkan jumlah stok yang ingin ditambahkan (harus lebih dari 0): ");
        int additionalStock = Laksa13.nextInt();
        while (additionalStock < 1) {
            System.out.println("Stok yang dimasukkan harus lebih dari 0! Silakan coba lagi.");
            System.out.print("Masukkan jumlah stok yang ingin ditambahkan (harus lebih dari 0): ");
            additionalStock = Laksa13.nextInt();
        }

        int currentStock = Integer.parseInt(items[itemID][2]); // [2] = Stok
        items[itemID][2] = String.valueOf(currentStock + additionalStock); // Add the currentStock with additionalStock

        System.out.println("Stok " + items[itemID][0] + " berhasil ditambah.");
        System.out.println("Stok sekarang: " + items[itemID][2]);
        return items;
    }

    static String[][] addItemData(String[][] items) {
        Laksa13.nextLine();
        System.out.println("==== TAMBAH ITEM ====");

        if (items.length >= 10) {
            System.out.println("Maaf, inventori sudah penuh!");
            return items;
        }

        System.out.print("Masukkan nama item baru: ");
        String itemName = Laksa13.nextLine();

        while (itemName.trim().isEmpty()) {
            System.out.println("Nama item tidak boleh kosong! Silakan coba lagi.");
            System.out.print("Masukkan nama item baru: ");
            itemName = Laksa13.nextLine();
        }

        System.out.print("Masukkan kategori item baru: ");
        String itemCategory = Laksa13.nextLine();

        while (itemCategory.trim().isEmpty()) {
            System.out.println("Kategori item tidak boleh kosong! Silakan coba lagi.");
            System.out.print("Masukkan kategori item baru: ");
            itemCategory = Laksa13.nextLine();
        }

        System.out.print("Masukkan jumlah stok awal (harus lebih dari 0): ");
        int itemStock = Laksa13.nextInt();

        while (itemStock < 1) {
            System.out.println("Stok yang dimasukkan harus lebih dari 0! Silakan coba lagi.");
            System.out.print("Masukkan jumlah stok awal (harus lebih dari 0): ");
            itemStock = Laksa13.nextInt();
        }

        String[][] newItems = new String[items.length + 1][3]; // Row item + 1, column 3

        for (int i = 0; i < items.length; i++) {
            System.arraycopy(items[i], 0, newItems[i], 0, items[i].length);
        }

        // Set items property
        newItems[items.length][0] = itemName; // [0] => Nama Item
        newItems[items.length][1] = itemCategory; // [1] => Kategori
        newItems[items.length][2] = String.valueOf(itemStock); // [1] => Stok Item

        System.out.println(
                "Item baru berhasil ditambahkan! : " + itemName + " (" + itemCategory + ") - Stok : " + itemStock);

        return newItems;
    }

    public static void main(String[] args) throws Exception {

        String[][] items = {};

        do {
            menus();
            int userChoice13 = Laksa13.nextInt();

            if (userChoice13 == 1) {
                if (items.length > 0) {
                    displayData(items);
                } else {
                    System.out.println("Tidak ada data inventori!");
                }
                backToMenu();
            } else if (userChoice13 == 2) {
                items = addStockData(items);
                backToMenu();
            } else if (userChoice13 == 3) {
                items = addItemData(items);
                backToMenu();
            } else {
                status = false;
            }

        } while (status);

        System.out.println("Terimakasih telah menggunakan program kami!");

    }

}
