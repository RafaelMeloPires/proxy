public class ProntuarioProxy implements IProntuario {

    private Prontuario prontuario;
    private String paciente;
    private String diagnostico;

    public ProntuarioProxy(String paciente, String diagnostico) {
        this.paciente = paciente;
        this.diagnostico = diagnostico;
    }

    public String obterDadosPaciente() {
        if (prontuario == null) {
            prontuario = new Prontuario(paciente, diagnostico);
        }

        return prontuario.obterDadosPaciente();
    }

    public String obterDiagnostico(Medico medico) {
        if (!medico.isAutorizado()) {
            throw new IllegalArgumentException("Médico não autorizado");
        }

        if (prontuario == null) {
            prontuario = new Prontuario(paciente, diagnostico);
        }

        return prontuario.obterDiagnostico(medico);
    }
}