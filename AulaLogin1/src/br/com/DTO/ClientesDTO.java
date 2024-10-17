/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.DTO;


public class ClientesDTO {
     private int id_cliente;
    private String  nomeClientes, enderecoClientes, telefoneClientes, emailClientes, cpfClientes;

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    

    public String getNomeClientes() {
        return nomeClientes;
    }

    public void setNomeClientes(String nomeClientes) {
        this.nomeClientes = nomeClientes;
    }

    public String getEnderecoClientes() {
        return enderecoClientes;
    }

    public void setEnderecoClientes(String enderecoClientes) {
        this.enderecoClientes = enderecoClientes;
    }

    public String getTelefoneClientes() {
        return telefoneClientes;
    }

    public void setTelefoneClientes(String telefoneClientes) {
        this.telefoneClientes = telefoneClientes;
    }

    public String getEmailClientes() {
        return emailClientes;
    }

    public void setEmailClientes(String emailClientes) {
        this.emailClientes = emailClientes;
    }

    public String getCpfClientes() {
        return cpfClientes;
    }

    public void setCpfClientes(String cpfClientes) {
        this.cpfClientes = cpfClientes;
    }
    
}
