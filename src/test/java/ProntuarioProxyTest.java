import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProntuarioProxyTest {

    @Test
    void deveRetornarDadosPaciente() {
        ProntuarioProxy prontuario =
                new ProntuarioProxy("Carlos", "Gripe");

        assertEquals("Carlos",
                prontuario.obterDadosPaciente());
    }

    @Test
    void deveRetornarDadosPacienteNovamente() {
        ProntuarioProxy prontuario =
                new ProntuarioProxy("Carlos", "Gripe");

        prontuario.obterDadosPaciente();

        assertEquals("Carlos",
                prontuario.obterDadosPaciente());
    }

    @Test
    void deveRetornarDiagnosticoMedicoAutorizado() {
        ProntuarioProxy prontuario =
                new ProntuarioProxy("Carlos", "Gripe");

        Medico medico = new Medico("João", true);

        assertEquals("Gripe",
                prontuario.obterDiagnostico(medico));
    }

    @Test
    void deveRetornarDiagnosticoProntuarioCarregado() {
        ProntuarioProxy prontuario =
                new ProntuarioProxy("Carlos", "Gripe");

        Medico medico = new Medico("João", true);

        prontuario.obterDadosPaciente();

        assertEquals("Gripe",
                prontuario.obterDiagnostico(medico));
    }

    @Test
    void deveRetornarDadosAposConsultarDiagnostico() {
        ProntuarioProxy prontuario =
                new ProntuarioProxy("Carlos", "Gripe");

        Medico medico = new Medico("João", true);

        prontuario.obterDiagnostico(medico);

        assertEquals("Carlos",
                prontuario.obterDadosPaciente());
    }

    @Test
    void deveRetornarExcecaoMedicoNaoAutorizado() {
        try {
            ProntuarioProxy prontuario =
                    new ProntuarioProxy("Carlos", "Gripe");

            Medico medico = new Medico("Pedro", false);

            prontuario.obterDiagnostico(medico);

            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Médico não autorizado",
                    e.getMessage());
        }
    }

    @Test
    void deveRetornarExcecaoProntuarioJaCarregado() {
        try {
            ProntuarioProxy prontuario =
                    new ProntuarioProxy("Carlos", "Gripe");

            Medico medico = new Medico("Pedro", false);

            prontuario.obterDadosPaciente();
            prontuario.obterDiagnostico(medico);

            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Médico não autorizado",
                    e.getMessage());
        }
    }
}