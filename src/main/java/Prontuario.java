public class Prontuario implements IProntuario {

    private String paciente;
    private String diagnostico;

    public Prontuario(String paciente, String diagnostico) {
        this.paciente = paciente;
        this.diagnostico = diagnostico;
    }

    public String obterDadosPaciente() {
        return paciente;
    }

    public String obterDiagnostico(Medico medico) {
        return diagnostico;
    }
}
