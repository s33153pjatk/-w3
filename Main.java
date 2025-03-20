public class Main {
    public static void main(String[] args) {
        Produkt produkt1 = new Produkt(1, "Laptop", "Laptop", 3500.00, 10);
        Produkt produkt2 = new Produkt(2, "Myszka", "Mysz", 100.00, 50);
        Produkt produkt3 = new Produkt(3, "Monitor", "Monitor", 800.00, 20);

        Klient klient1 = new Klient(1, "Jan", "Kowalski", "jan.kowalski@email.com", true);
        Klient klient2 = new Klient(2, "Anna", "Nowak", "anna.nowak@email.com", false);

        SklepKomputerowy sklep = new SklepKomputerowy();

        sklep.dodajProdukt(produkt1);
        sklep.dodajProdukt(produkt2);
        sklep.dodajProdukt(produkt3);

        sklep.dodajKlienta(klient1);
        sklep.dodajKlienta(klient2);

        Produkt[] produktyZamowienie = {produkt1, produkt2};
        int[] ilosciZamowienie = {1, 2};
        sklep.utworzZamowienie(klient1, produktyZamowienie, ilosciZamowienie);

        Produkt[] produktyZamowienie2 = {produkt3};
        int[] ilosciZamowienie2 = {1};
        sklep.utworzZamowienie(klient2, produktyZamowienie2, ilosciZamowienie2);

        System.out.println("Szczegóły zamówienia klienta 1:");
        sklep.wyswietlZamowieniaKlienta(klient1.getId());

        System.out.println("\nSzczegóły zamówienia klienta 2:");
        sklep.wyswietlZamowieniaKlienta(klient2.getId());

        sklep.zmienStatusZamowienia(1, "W realizacji");
        System.out.println("\nPo zmianie statusu:");
        sklep.wyswietlZamowieniaKlienta(klient1.getId());

        System.out.println("\nProdukty w kategorii 'Laptop':");
        sklep.wyswietlProduktyWKategorii("Laptop");
    }
}
