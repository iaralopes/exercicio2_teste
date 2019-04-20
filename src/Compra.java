import java.util.List;

public class Compra {
    List<Vinho> itens;
    int index = -1;

    Vinho inserirVinho(Vinho vinho) {
        if (vinhoValido(vinho)) {
            index = index + 1;
            itens.add(vinho);
        } else {
            throw new IllegalArgumentException();
        }
        return itens.get(index);
    }

    boolean vinhoValido(Vinho vinho) {
        boolean vinhoValido = true;
        if (vinho == null) {
            vinhoValido = false;
        } else if (vinho.getNome() == null) {
            vinhoValido = false;
        }

        return vinhoValido;
    }

    Vinho buscarVinho(int n) {
        Vinho vinho = itens.get(n);
        if (vinho == null) {
            throw new IllegalArgumentException();
        }
        return vinho;
    }

    double calcValorTotal() {
        double valorCompra = calcValorCompra();
        double valorTotal = valorCompra + calcValorFrete(valorCompra);
        return valorTotal;
    }

    double calcValorCompra() {
        double valorCompra = 0;
        for (int index = 0; index < itens.size(); index++) {
            valorCompra = itens.get(index).getPreco() + valorCompra;
        }

        return valorCompra;
    }

    double calcValorFrete(double valorCompra) {
        double valorFrete = 0.00;

        if (valorCompra >= 1 && valorCompra <= 100) {
            valorFrete = 15.00;
        } else if (valorCompra >= 101 && valorCompra <= 200) {
            valorFrete = 10.00;
        }

        return valorFrete;
    }

}
