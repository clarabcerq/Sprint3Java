package br.com.fiap.sprint3_EcoPredict.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_empresa")
    @NotBlank(message = "o nome é obrigatório")
    private String nomeEmpresa;

    @Column(name = "email")
    @NotBlank(message = "o nome é obrigatório")
    private String email;

    @Column(name = "senha")
    @NotBlank(message = "a senha é obrigatória")
    private String senha;

    @Column(name = "cnpj")
    @Size(min = 11, max = 11)
    private String cnpj;

    @OneToMany(mappedBy = "usuario")
    private List<Arquivo> arquivos;

    public List<Arquivo> getArquivos() {
        return arquivos;
    }

    public void setArquivos(List<Arquivo> arquivos) {
        this.arquivos = arquivos;
    }

    public Long getId() { return id; }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public @Size(min = 11, max = 11) String getCnpj() {
        return cnpj;
    }

    public void setCnpj(@Size(min = 11, max = 11) String cnpj) {
        this.cnpj = cnpj;
    }
}
