/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.DAO;

import br.com.DTO.ClientesDTO;
import br.com.DAO.ClientesDAO;
import br.com.views.TelaClientes;
import br.com.views.TelaPrincipal;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aluno.saolucas
 */
public class ClientesDAO {
     Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

  

    public void inserirCliente(ClientesDTO objClienteDTO) {
        String sql = "insert into tb_Clientes (id_clientes, nome, endereco, telefone, email, cpf_cnpj )"
                + " values (?, ?, ?, ?, ?, ?)";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objClienteDTO.getId_cliente());
            pst.setString(2, objClienteDTO.getNomeClientes());
            pst.setString(3, objClienteDTO.getEnderecoClientes());
            pst.setString(4, objClienteDTO.getTelefoneClientes());
            pst.setString(5, objClienteDTO.getEmailClientes());
            pst.setString(6, objClienteDTO.getCpfClientes());
            int add  = pst.executeUpdate();
            if (add > 0) {
                pesquisaAuto();
                pst.close();
                limparCampos();
                JOptionPane.showMessageDialog(null, "Cliente inserido com sucesso! ");
            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, " Método Inserir " + e);
        }
    }

    public void pesquisar(ClientesDTO objClienteDTO) {
        String sql = "select * from tb_Clientes where id_clientes = ?";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objClienteDTO.getId_cliente());
            rs = pst.executeQuery();
            if (rs.next()) {
                TelaClientes.txtNomeCli.setText(rs.getString(2));
                TelaClientes.txtEndCli.setText(rs.getString(3));
                TelaClientes.txtTelefone.setText(rs.getString(4));
                TelaClientes.txtEmail.setText(rs.getString(5));
                TelaClientes.txtCpf.setText(rs.getString(6));
               
             
                conexao.close();
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não cadastrado!");
                limparCampos();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Método Pesquisar" + e);
        }
    }

    public void pesquisaAuto() {
        String sql = "select * from tb_Clientes";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) TelaClientes.TbCliente.getModel();
            model.setNumRows(0);

            while (rs.next()) {
                int id = rs.getInt("id_clientes");
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                String cpf = rs.getString("cpf_cnpj");
                model.addRow(new Object[]{id, nome, endereco, telefone, email,  cpf});
            }
            conexao.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Método Pesquisar Automático " + e);
        }
    }

    //Método editar
    public void editar(ClientesDTO objClienteDTO) {
        String sql = "update tb_Clientes set nome = ?, endereco = ?, telefone = ?, email = ?, cpf_cnpj = ?  where id_clientes = ?";
        conexao = ConexaoDAO.conector();
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, objClienteDTO.getNomeClientes());
            pst.setString(2, objClienteDTO.getEnderecoClientes());
            pst.setString(3, objClienteDTO.getTelefoneClientes());
            pst.setString(4, objClienteDTO.getEmailClientes());
            pst.setString(5, objClienteDTO.getCpfClientes());
            pst.setInt(6, objClienteDTO.getId_cliente());
            int add = pst.executeUpdate();
            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Cliente editado com sucesso!");
                pesquisaAuto();
                conexao.close();
                limparCampos();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Método editar " + e);
        }
    }

    //Método deletar
    public void deletar(ClientesDTO objClienteDTO) {
        String sql = "delete from tb_Clientes where id_clientes = ?";
        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objClienteDTO.getId_cliente());
            int del = pst.executeUpdate();
            if (del > 0) {
                JOptionPane.showMessageDialog(null, " Clientes deletado com sucesso!");
                pesquisaAuto();
                conexao.close();
                limparCampos();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Método deletar " + e);
        }
    }

    public void limparCampos() {
        TelaClientes.txtIdCli.setText(null);
        TelaClientes.txtEndCli.setText(null);
        TelaClientes.txtNomeCli.setText(null);
        TelaClientes.txtTelefone.setText(null);
        TelaClientes.txtEmail.setText(null);
        TelaClientes.txtCpf.setText(null);
        
    }

}


