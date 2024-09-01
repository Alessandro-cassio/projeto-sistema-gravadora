package modelo;
public class Estudio {
    private int id;
    private String nome;
    private int numMusicasGravadas;
    private double taxaHoraEstudio;

    // Construtor
    public Estudio(int id, String nome, int numMusicasGravadas, double taxaHoraEstudio) {
        this.id = id;
        this.nome = nome;
        this.numMusicasGravadas = numMusicasGravadas;
        this.taxaHoraEstudio = taxaHoraEstudio;
    }

    // Getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumMusicasGravadas() {
        return numMusicasGravadas;
    }

    public void setNumMusicasGravadas(int numMusicasGravadas) {
        this.numMusicasGravadas = numMusicasGravadas;
    }

    public double getTaxaHoraEstudio() {
        return taxaHoraEstudio;
    }

    public void setTaxaHoraEstudio(double taxaHoraEstudio) {
        this.taxaHoraEstudio = taxaHoraEstudio;
    }

    // Método para calcular o faturamento
    public double calcularFaturamento(int horas) {
        return horas * taxaHoraEstudio;
    }

    // Métodos para agendar sessão e mixar música podem ser adicionados aqui
}
