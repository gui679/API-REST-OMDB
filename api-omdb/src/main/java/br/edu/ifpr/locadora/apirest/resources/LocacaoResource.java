package br.edu.ifpr.locadora.apirest.resources;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.edu.ifpr.locadora.apirest.models.Filme;
import br.edu.ifpr.locadora.apirest.models.Locacao;
import br.edu.ifpr.locadora.apirest.models.LocacaoGet;
import br.edu.ifpr.locadora.apirest.models.LocacaoRequest;
import br.edu.ifpr.locadora.apirest.repository.LocacaoRepository;
import br.edu.ifpr.locadora.apirest.repository.ClienteRepository;

@RestController
@RequestMapping(value="/api")
public class LocacaoResource {
	
	@Autowired
	LocacaoRepository locacaoRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@GetMapping("/locacoes")
	public ArrayList<LocacaoGet> listaLocacao(){
		ArrayList<LocacaoGet> lista = new ArrayList<>();
		locacaoRepository.findAll().forEach((Locacao get) -> {
			LocacaoGet set = new LocacaoGet();
			set.setId(get.getId());
			set.setCliente(get.getCliente());
			set.setData(get.getData());
			set.setDevolucao(get.getDevolucao());
			set.setValor(get.getValor());
			final String uri = ("http://omdbapi.com/?apikey=8ee5444a&i="+get.getFilme()+"&");
		     
		    RestTemplate restTemplate = new RestTemplate();
			
			set.setFilme(restTemplate.getForObject(uri, Filme.class));
			
			lista.add(set);
		});
		return lista; 
	}
	
	@GetMapping("/locacao/{id}")
	public LocacaoGet listaLocacaoUnica(@PathVariable(value="id") long id){
		Locacao get = new Locacao();
		LocacaoGet set = new LocacaoGet();
		get = locacaoRepository.findById(id);
		set.setId(get.getId());
		set.setCliente(get.getCliente());
		set.setData(get.getData());
		set.setDevolucao(get.getDevolucao());
		set.setValor(get.getValor());
		final String uri = ("http://omdbapi.com/?apikey=8ee5444a&i="+get.getFilme()+"&");
	     
	    RestTemplate restTemplate = new RestTemplate();
		
		set.setFilme(restTemplate.getForObject(uri, Filme.class));
		
		return set;
	}
	
	@PostMapping("/locacao")
	public Locacao salvaLocacao(@RequestBody LocacaoRequest request) {
		Locacao locacao = new Locacao();
		locacao.setData(request.getData());
		locacao.setDevolucao(request.getDevolucao());
		locacao.setCliente(clienteRepository.findById(request.getCliente()));
		locacao.setValor(request.getValor());
		locacao.setFilme(request.getFilme());
		return locacaoRepository.save(locacao);
	}
	
	@DeleteMapping("/locacao")
	public void deletaLocacao(@RequestBody Locacao locacao) {
		locacaoRepository.delete(locacao);
	}
	
	@DeleteMapping("/locacao/{id}")
	public void deletaLocacaoPorId(@PathVariable(value="id") long id) {
		Locacao locacao = new Locacao();
		locacao = locacaoRepository.findById(id);
		locacaoRepository.delete(locacao);
	}
	
	@PutMapping("/locacao")
	public Locacao atualizaLocacao(@RequestBody LocacaoRequest request) {
		Locacao locacao = new Locacao();
		locacao.setId(request.getId());
		locacao.setData(request.getData());
		locacao.setDevolucao(request.getDevolucao());
		locacao.setCliente(clienteRepository.findById(request.getCliente()));
		locacao.setValor(request.getValor());
		locacao.setFilme(request.getFilme());
		return locacaoRepository.save(locacao);
	}
	
	@PutMapping("/locacao/{id}")
	public Locacao atualizaLocacaoComId(@RequestBody LocacaoRequest request, @PathVariable(value="id") long id) {
		Locacao locacao = new Locacao();
		locacao.setId(id);
		locacao.setData(request.getData());
		locacao.setDevolucao(request.getDevolucao());
		locacao.setCliente(clienteRepository.findById(request.getCliente()));
		locacao.setValor(request.getValor());
		locacao.setFilme(request.getFilme());
		return locacaoRepository.save(locacao);
	}
}
