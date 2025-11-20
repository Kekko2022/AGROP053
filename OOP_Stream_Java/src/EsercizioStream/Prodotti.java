package EsercizioStream;

public class Prodotti {
    private String id;
    private String nome;
    private String categoria;
    private double prezzo;
    private int quantitaDisponibile;

    public Prodotti(String id, String nome, String categoria, double prezzo, int quantitaDisponibile) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.prezzo = prezzo;
        this.quantitaDisponibile = quantitaDisponibile;
    }

    public String getId() {return id;}
    public String getNome() {return nome;}
    public String getCategoria() {return categoria;}
    public double getPrezzo() {return prezzo;}
    public int getQuantitaDisponibile() {return quantitaDisponibile;}

    @Override
    public String toString() {
        return "Prodotti{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", categoria='" + categoria + '\'' +
                ", prezzo=" + prezzo +
                ", quantitaDisponibile=" + quantitaDisponibile +
                '}';
    }
}
