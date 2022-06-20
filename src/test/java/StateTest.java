/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit3TestClass.java to edit this template
 */

import com.gqs.tf_gqualidade.business.Business;
import com.gqs.tf_gqualidade.state.AguardandoPagamentoState;
import com.gqs.tf_gqualidade.state.CanceladoPeloClienteState;
import com.gqs.tf_gqualidade.state.CanceladoPeloEstabelecimentoState;
import com.gqs.tf_gqualidade.state.ConfirmadoState;
import com.gqs.tf_gqualidade.state.EmRotaDeEntregaState;
import com.gqs.tf_gqualidade.state.EntregueState;
import com.gqs.tf_gqualidade.state.NovoState;
import com.gqs.tf_gqualidade.state.ProntoParaEntregaState;
import com.gqs.tf_gqualidade.state.ReembolsadoState;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Lucas dos Santos Carvalho
 */
public class StateTest {

    private static Business b;

    @BeforeAll
    public static void antes() throws Exception {

    }

    @BeforeEach
    public void antesDeCada() throws Exception {
        b = new Business();
        b.criarPedido("Fulano de Tal");
    }

    @Test
    @DisplayName("Pedido Criado - Entregue")
    public void CT001() throws Exception {
        b.getPedido().getEstado().incluir(1, 1);
        assertThat(b.getPedido().getEstado(), instanceOf(NovoState.class));
        b.getPedido().getEstado().concluir();
        assertThat(b.getPedido().getEstado(), instanceOf(AguardandoPagamentoState.class));
        b.getPedido().getEstado().concluir();
        assertThat(b.getPedido().getEstado(), instanceOf(ConfirmadoState.class));
        b.getPedido().getEstado().concluir();
        assertThat(b.getPedido().getEstado(), instanceOf(ProntoParaEntregaState.class));
        b.getPedido().getEstado().concluir();
        assertThat(b.getPedido().getEstado(), instanceOf(EmRotaDeEntregaState.class));
        b.getPedido().getEstado().concluir();
        assertThat(b.getPedido().getEstado(), instanceOf(EntregueState.class));
        b.getPedido().getEstado().concluir();
    }

    @Test
    @DisplayName("Pedido Criado - Cancelado pelo Cliente")
    public void CT002() throws Exception {
        b.getPedido().getEstado().incluir(15, 1);
        assertThat(b.getPedido().getEstado(), instanceOf(NovoState.class));
        b.getPedido().getEstado().cancelar();
        assertThat(b.getPedido().getEstado(), instanceOf(CanceladoPeloClienteState.class));
        b.getPedido().getEstado().concluir();
        assertThat(b.getPedido().getEstado(), instanceOf(ReembolsadoState.class));
        b.getPedido().getEstado().concluir();
    }

    @Test
    @DisplayName("Aguardando Pagamento - Cancelado Pelo Cliente")
    public void CT003() throws Exception {
        b.getPedido().getEstado().incluir(30, 1);
        assertThat(b.getPedido().getEstado(), instanceOf(NovoState.class));
        b.getPedido().getEstado().concluir();
        assertThat(b.getPedido().getEstado(), instanceOf(AguardandoPagamentoState.class));
        b.getPedido().getEstado().cancelar();
        assertThat(b.getPedido().getEstado(), instanceOf(CanceladoPeloClienteState.class));
        b.getPedido().getEstado().concluir();
        assertThat(b.getPedido().getEstado(), instanceOf(ReembolsadoState.class));
        b.getPedido().getEstado().concluir();
    }

    @Test
    @DisplayName("Confirmado - Cancelado Pelo Estabelecimento")
    public void CT004() throws Exception {
        b.getPedido().getEstado().incluir(40, 1);
        assertThat(b.getPedido().getEstado(), instanceOf(NovoState.class));
        b.getPedido().getEstado().concluir();
        assertThat(b.getPedido().getEstado(), instanceOf(AguardandoPagamentoState.class));
        b.getPedido().getEstado().concluir();
        assertThat(b.getPedido().getEstado(), instanceOf(ConfirmadoState.class));
        b.getPedido().getEstado().cancelar();
        assertThat(b.getPedido().getEstado(), instanceOf(CanceladoPeloEstabelecimentoState.class));
        b.getPedido().getEstado().concluir();
        assertThat(b.getPedido().getEstado(), instanceOf(ReembolsadoState.class));
        b.getPedido().getEstado().concluir();
    }

    @Test
    @DisplayName("Pronto Para Entrega - Cancelado Pelo Estabelecimento")
    public void CT005() throws Exception {
        b.getPedido().getEstado().incluir(5, 1);
        assertThat(b.getPedido().getEstado(), instanceOf(NovoState.class));
        b.getPedido().getEstado().concluir();
        assertThat(b.getPedido().getEstado(), instanceOf(AguardandoPagamentoState.class));
        b.getPedido().getEstado().concluir();
        assertThat(b.getPedido().getEstado(), instanceOf(ConfirmadoState.class));
        b.getPedido().getEstado().concluir();
        assertThat(b.getPedido().getEstado(), instanceOf(ProntoParaEntregaState.class));
        b.getPedido().getEstado().cancelar();
        assertThat(b.getPedido().getEstado(), instanceOf(CanceladoPeloEstabelecimentoState.class));
        b.getPedido().getEstado().concluir();
        assertThat(b.getPedido().getEstado(), instanceOf(ReembolsadoState.class));
        b.getPedido().getEstado().concluir();
    }
    
    @Test
    @DisplayName("Cesta Econômica")
    public void CT006() throws Exception {
        b.getPedido().getEstado().incluir(1, 1);
        b.getPedido().getEstado().incluir(1);
        assertThat(b.getPedido().getEstado(), instanceOf(NovoState.class));
        b.getPedido().getEstado().concluir();
        assertThat(b.getPedido().getEstado(), instanceOf(AguardandoPagamentoState.class));
        b.getPedido().getEstado().concluir();
        assertThat(b.getPedido().getEstado(), instanceOf(ConfirmadoState.class));
        b.getPedido().getEstado().concluir();
        assertThat(b.getPedido().getEstado(), instanceOf(ProntoParaEntregaState.class));
        b.getPedido().getEstado().concluir();
        assertThat(b.getPedido().getEstado(), instanceOf(EmRotaDeEntregaState.class));
        b.getPedido().getEstado().concluir();
        assertThat(b.getPedido().getEstado(), instanceOf(EntregueState.class));
        b.getPedido().getEstado().concluir();
    }
    
    @Test
    @DisplayName("Cesta Básica")
    public void CT007() throws Exception {
        b.getPedido().getEstado().incluir(1, 1);
        b.getPedido().getEstado().incluir(2);
        assertThat(b.getPedido().getEstado(), instanceOf(NovoState.class));
        b.getPedido().getEstado().concluir();
        assertThat(b.getPedido().getEstado(), instanceOf(AguardandoPagamentoState.class));
        b.getPedido().getEstado().concluir();
        assertThat(b.getPedido().getEstado(), instanceOf(ConfirmadoState.class));
        b.getPedido().getEstado().concluir();
        assertThat(b.getPedido().getEstado(), instanceOf(ProntoParaEntregaState.class));
        b.getPedido().getEstado().concluir();
        assertThat(b.getPedido().getEstado(), instanceOf(EmRotaDeEntregaState.class));
        b.getPedido().getEstado().concluir();
        assertThat(b.getPedido().getEstado(), instanceOf(EntregueState.class));
        b.getPedido().getEstado().concluir();
    }
    
    @Test
    @DisplayName("Cesta TOP")
    public void CT008() throws Exception {
        b.getPedido().getEstado().incluir(1, 1);
        b.getPedido().getEstado().incluir(3);
        assertThat(b.getPedido().getEstado(), instanceOf(NovoState.class));
        b.getPedido().getEstado().concluir();
        assertThat(b.getPedido().getEstado(), instanceOf(AguardandoPagamentoState.class));
        b.getPedido().getEstado().concluir();
        assertThat(b.getPedido().getEstado(), instanceOf(ConfirmadoState.class));
        b.getPedido().getEstado().concluir();
        assertThat(b.getPedido().getEstado(), instanceOf(ProntoParaEntregaState.class));
        b.getPedido().getEstado().concluir();
        assertThat(b.getPedido().getEstado(), instanceOf(EmRotaDeEntregaState.class));
        b.getPedido().getEstado().concluir();
        assertThat(b.getPedido().getEstado(), instanceOf(EntregueState.class));
        b.getPedido().getEstado().concluir();
    }
    
}
