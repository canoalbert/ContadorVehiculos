package alberto.cano.contadorvehiculos.modelos;

import java.io.Serializable;

public class Bici implements Serializable {
    private String marca;
    private String pulgadas;

    public Bici(String marca, String pulgadas) {
        this.marca = marca;
        this.pulgadas = pulgadas;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(String pulgadas) {
        this.pulgadas = pulgadas;
    }

    public Bici() {
    }

    @Override
    public String toString() {
        return "Bici{" +
                "marca='" + marca + '\'' +
                ", pulgadas='" + pulgadas + '\'' +
                '}';
    }
}
