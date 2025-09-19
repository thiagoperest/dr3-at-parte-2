package br.edu.infnet.dr3atparte2.dto;

public class MensalistaResponseDto {

    private Long id;
    private String matricula;
    private String nome;
    private String cargo;
    private Double salario;

    public MensalistaResponseDto() {
    }

    public MensalistaResponseDto(Long id, String matricula, String nome, String cargo, Double salario) {
        this.id = id;
        this.matricula = matricula;
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "MensalistaResponseDto{" +
                "id=" + id +
                ", matricula='" + matricula + '\'' +
                ", nome='" + nome + '\'' +
                ", cargo='" + cargo + '\'' +
                ", salario=" + salario +
                '}';
    }
}
