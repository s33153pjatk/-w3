import java.util.ArrayList;

public class SklepKomputerowy {
    private ArrayList<Produkt> produkty = new ArrayList<>();
    private ArrayList<Klient> klienci = new ArrayList<>();
    private ArrayList<Zamowienie> zamowienia = new ArrayList<>();

    public void dodajProdukt(Produkt produkt) {
        produkty.add(produkt);
    }

    public void dodajKlienta(Klient klient) {
        klienci.add(klient);
    }

    public void utworzZamowienie(Klient klient, Produkt[] produkty, int[] ilosci) {
        int id = zamowienia.size() + 1;
        Zamowienie zamowienie = new Zamowienie(id, klient, produkty, ilosci, "2025-03-20");
        zamowienia.add(zamowienie);
        aktualizujStanMagazynowy(zamowienie);
    }

    public void aktualizujStanMagazynowy(Zamowienie zamowienie) {
        for (int i = 0; i < zamowienie.getProdukty().length; i++) {
            Produkt produkt = zamowienie.getProdukty()[i];
            int ilosc = zamowienie.getIlosci()[i];
            produkt.setIloscWMagazynie(produkt.getIloscWMagazynie() - ilosc);
        }
    }

    public void zmienStatusZamowienia(int idZamowienia, String nowyStatus) {
        for (Zamowienie z : zamowienia) {
            if (z.getId() == idZamowienia) {
                z.setStatus(nowyStatus);
            }
        }
    }

    public void wyswietlProduktyWKategorii(String kategoria) {
        for (Produkt p : produkty) {
            if (p.getKategoria().equals(kategoria)) {
                p.wyswietlInformacje();
            }
        }
    }

    public void wyswietlZamowieniaKlienta(int idKlienta) {
        for (Zamowienie z : zamowienia) {
            if (z.getKlient().getId() == idKlienta) {
                z.wyswietlSzczegoly();
            }
        }
    }
}
