package br.edu.infnet.dr3atparte2.dto;

public class MensalistaRequestDto {

    private String matricula;
    private String nome;
    private String cargo;
    private Double salario;

    public MensalistaRequestDto() {
    }

    public MensalistaRequestDto(String matricula, String nome, String cargo, Double salario) {
        this.matricula = matricula;
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "MensalistaRequestDto{" +
                "matricula='" + matricula + '\'' +
                ", nome='" + nome + '\'' +
                ", cargo='" + cargo + '\'' +
                ", salario=" + salario +
                '}';
    }
}
