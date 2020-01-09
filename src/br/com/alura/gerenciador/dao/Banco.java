package br.com.alura.gerenciador.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.alura.gerenciador.model.Empresa;
import br.com.alura.gerenciador.model.Usuario;

public class Banco {
	private static List<Empresa> empresas = new ArrayList<>();
	private static List<Usuario> usuarios = new ArrayList<>();
	private static Integer sequentialKey = 1;
	
	static {
		usuarios.addAll(Arrays.asList(
				new Usuario("guacom", "12345"),
				new Usuario("marco", "123456")));
		empresas.addAll(Arrays.asList(
				new Empresa(Banco.sequentialKey, "Caelum"),
				new Empresa(++Banco.sequentialKey, "Alura"),
				new Empresa(++Banco.sequentialKey, "Capgemini")));
	}
	
	public void adiciona(Empresa empresa) {
		empresa.setId(++Banco.sequentialKey);
		Banco.empresas.add(empresa);
	}
	
	public Optional<Usuario> findByLoginAndSenha(String login, String senha) {
		return usuarios.stream()
				.filter(u -> u.ehIgual(login, senha))
				.findFirst();
	}
	
	public Optional<Empresa> findById(Integer id) {
		return empresas.stream().filter(e -> e.getId() == id)
				.findFirst();
	}
	
	public void remove(Integer id) {
		empresas = empresas.stream()
				.dropWhile(e -> e.getId() == id)
				.collect(Collectors.toList());
	}
	
	public List<Empresa> getEmpresas() {
		return Banco.empresas;
	}
}