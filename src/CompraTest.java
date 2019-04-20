import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CompraTest {

    private Compra compra;

    @Mock
    List<Vinho> itensCompra;

    @Mock
    Vinho vinho;

    @Before
    public void inicializador() {
        MockitoAnnotations.initMocks(this);
        compra = new Compra();
        compra.itens = itensCompra;
    }

    @Test
    public void retornaVinhoInseridoQuandoVinhoValidoInserido() {
        when(itensCompra.get(0)).thenReturn(vinho);
        when(vinho.getNome()).thenReturn("vinho da serra");

        assertEquals(vinho, compra.inserirVinho(vinho));
    }

    @Test(expected=IllegalArgumentException.class)
    public void retornaExceptionQuandoVinhoSemDadoSuficientesInserido() {
        when(vinho.getNome()).thenReturn(null);

        assertEquals(vinho, compra.inserirVinho(vinho));
    }

    @Test(expected=IllegalArgumentException.class)
    public void retornaExceptionQuandoVinhoInvalidoInserido() {
        assertNull(compra.inserirVinho(null));
    }

    @Test
    public void retornaVinhoDesejadoQuandoSolicitaVinhoAtravesDePosicaoExistente() {
        when(itensCompra.get(5)).thenReturn(vinho);

        assertEquals(vinho, compra.buscarVinho(5));
    }

    @Test(expected=IllegalArgumentException.class)
    public void retornaExceptionQuandoSolicitaUmVinhoAtravesDePosicaoNaoExistente() {
        assertNull(compra.buscarVinho(10));
    }

    @Test
    public void retornaValorDaCompraQuandoCalculaValorDaListaDeCompraComItens() {
        when(itensCompra.get(0)).thenReturn(vinho);
        when(itensCompra.size()).thenReturn(1);

        when(vinho.getNome()).thenReturn("vinho do sol");
        when(vinho.getPreco()).thenReturn(10.00);

        assertEquals(10.00, compra.calcValorCompra(), 0);
    }

    @Test
    public void retornaValorDaCompraZeradoQuandoCalculaValorDaListaDeCompraSemItens() {
        when(itensCompra.size()).thenReturn(0);

        assertEquals(0.00, compra.calcValorCompra(), 0);
    }

    @Test
    public void retornaValorDoFreteAdequadoQuandoCalculaValorDoFreteParaValorMaiorQueZeroEMenorIgualACem() {
        assertEquals(15.00, compra.calcValorFrete(90.00), 0);
    }

    @Test
    public void retornaValorDoFreteAdequadoQuandoCalculaValorDoFreteParaValorMaiorQueCemEMenorQueDuzentos() {
        assertEquals(10.00, compra.calcValorFrete(105.00), 0);
    }

    @Test
    public void retornaValorDoFreteZeradoQuandoCalculaValorDoFreteParaValorMaiorQueDuzentos() {
        assertEquals(0.00, compra.calcValorFrete(350.00), 0);
    }

    @Test
    public void retornaValorDoFreteZeradoQuandoCalculaValorDoFreteParaValorIgualZero() {
        assertEquals(0.00, compra.calcValorFrete(0.00), 0);
    }

    @Test
    public void retornaValorTotalQuandoCalculaValorTotalComFrete() {
        when(itensCompra.get(0)).thenReturn(vinho);
        when(itensCompra.size()).thenReturn(1);

        when(vinho.getNome()).thenReturn("vinho do sol");
        when(vinho.getPreco()).thenReturn(10.00);

        assertEquals(25.00, compra.calcValorTotal(), 0);
    }

    @Test
    public void retornaValorTotalSemFreteQuandoCalculaValorTotalSemFrete() {
        when(itensCompra.get(0)).thenReturn(vinho);
        when(itensCompra.size()).thenReturn(1);

        when(vinho.getNome()).thenReturn("vinho do sol");
        when(vinho.getPreco()).thenReturn(350.00);

        assertEquals(350.00, compra.calcValorTotal(), 0);
    }

    @Test
    public void retornaValorTotalZeradoQuandoCalculaValorDaListaDeComprasSemItens() {
        when(itensCompra.size()).thenReturn(0);

        assertEquals(0.00, compra.calcValorTotal(), 0);
    }

}
