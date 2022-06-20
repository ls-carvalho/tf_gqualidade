/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit3TestClass.java to edit this template
 */

import com.gqs.tf_gqualidade.business.Business;
import com.gqs.tf_gqualidade.state.AguardandoPagamentoState;
import com.gqs.tf_gqualidade.state.ConfirmadoState;
import com.gqs.tf_gqualidade.state.EmRotaDeEntregaState;
import com.gqs.tf_gqualidade.state.EntregueState;
import com.gqs.tf_gqualidade.state.NovoState;
import com.gqs.tf_gqualidade.state.ProntoParaEntregaState;
import junit.framework.TestCase;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Lucas dos Santos Carvalho
 */
public class StateTest extends TestCase {

    private static final Business b = new Business();

    @BeforeAll
    public static void antes() throws Exception {
        b.criarPedido("Fulano de Tal");
        b.getPedido().getEstado().incluir(1, 2);
        b.getPedido().getEstado().incluir(1, 1);
        b.getPedido().getEstado().incluir(13, 1);
        b.getPedido().getEstado().incluir(1);
    }

    /*
    @BeforeEach
    public void antesDeCada() {

    }
    */
    
    @Test
    @DisplayName("Criação do Pedido")
    void CT001() {
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
