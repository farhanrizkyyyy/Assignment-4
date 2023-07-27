import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = 0, y = 0;
        float result = 0;
        char operator = ' ';

        while (true) {
            while (true) {
                System.out.print("Masukkan angka pertama: ");
                try {
                    x = scanner.nextInt(); // input angka pertama
                    if (x == 0) throw new Exception(); // lempar Exception jika input == 0
                    break;
                } catch (InputMismatchException e) {
                    printError(); // tampilkan pesan error jika input bukan Integer
                    scanner.next();
                } catch (Exception e) {
                    // tangkap Exception jika input == 0
                    System.out.println("Input harus merupakan bilangan bulat.");
                }
            }

            while (true) {
                System.out.print("Masukkan angka kedua: ");
                try {
                    y = scanner.nextInt(); // input angka kedua
                    if (y == 0) throw new Exception(); // lempar Exception jika input == 0
                    break;
                } catch (InputMismatchException e) {
                    printError(); // tampilkan pesan error jika input bukan Integer
                    scanner.next();
                } catch (Exception e) {
                    // tangkap Exception jika input == 0
                    System.out.println("Input harus merupakan bilangan bulat, silahkan input ulang.");
                }
            }

            while (true) {
                System.out.print("Masukkan operator aritmatika (+,-,*,/): ");
                try {
                    operator = scanner.next().charAt(0); // input operator matematika
                    switch (operator) {
                        // kalkulasi angka pertama dan angka kedua
                        case '+':
                            result = x + y;
                            break;
                        case '-':
                            result = x - y;
                            break;
                        case '*':
                            result = x * y;
                            break;
                        case '/':
                            // ubah angka pertama dan kedua menjadi float
                            // karena operasi bagi berkemungkinan menghasilan desimal
                            result = (float) x / (float) y;
                            break;
                        default:
                            // lempar Exception jika input tidak termasuk ke operator yang disediakan (+,-,*,/)
                            throw new Exception();
                    }
                    break;
                } catch (Exception e) {
                    // tangkap Exception jika input tidak termasuk ke operator yang disediakan
                    // atau input melebihi 1 karakter
                    System.out.println("Operator tidak valid, silahkan input ulang.");
                }
            }

            System.out.format("Hasil: %2.f\n", result); // print hasil kalkulasi ke CLI
        }
    }

    private static void printError() {
        System.out.println("Format input tidak valid, silahkan input ulang.");
    }
}