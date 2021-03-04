package com.projeto.accenture.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.common.base.Optional;
import com.projeto.accenture.dto.LancamentoDTO;
import com.projeto.accenture.dto.PlanoContaDTO;
import com.projeto.accenture.dto.UsuarioDTO;
import com.projeto.accenture.model.Conta;
import com.projeto.accenture.model.Lancamento;
import com.projeto.accenture.model.PlanosDeConta;
import com.projeto.accenture.model.Usuario;
import com.projeto.accenture.model.enums.TipoMovimento;
import com.projeto.accenture.repositories.IContaRepository;
import com.projeto.accenture.repositories.ILancamentoRepository;
import com.projeto.accenture.repositories.IPlanoDeContaRepository;
import com.projeto.accenture.repositories.IUsuarioRepository;
import com.projeto.accenture.services.exceptions.ObjectNotFoundException;
import com.projeto.accenture.services.exceptions.IllegalArgumentException;

@Service
public class LancamentoService {

	@Autowired
	private IContaRepository repoConta;
	
	@Autowired
	private ILancamentoRepository repoLancamento;
	
	@Autowired
	private IPlanoDeContaRepository repoPlano;
	
	@Autowired
	private IUsuarioRepository repoUser;
	
	
	public List<Lancamento> findAll(String login) {
		
		if(repoUser.findByLogin(login).isPresent()) {
			
			return repoLancamento.findAll();
		}
		
		throw new ObjectNotFoundException("Usuário não encontrado!");
		
	}
	
	public Lancamento insert(Lancamento obj , String login ) {
		if(repoUser.findByLogin(login).isPresent()) {
			Conta conta = new Conta();
			PlanosDeConta plano = new PlanosDeConta();
			plano = repoPlano.findByLogin(login);
			Conta contaDestino = new Conta();
		
		System.out.println("TIPO DE MOVIMENTO asfdas "+obj.getTipoMovimento());
			
			obj.setId(null);
			obj.setConta(repoConta.findByLogin(login));
			obj.setDataLancamento(LocalDate.now());
			obj.setPlanoConta(plano.getId());
			
			if(obj.getTipoMovimento()>=1 && obj.getTipoMovimento()<=3){
				
				System.out.println("TIPO DE MOVIMENTO "+obj.getTipoMovimento());
				conta = repoConta.findByLogin(login);
				
					if(obj.getTipoMovimento() == TipoMovimento.DESPESAS.getCod()) {
						obj.setContaDestino(null);
						if(obj.getValor()<=conta.getSaldo()) {
							
							conta.setSaldo(conta.getSaldo()- obj.getValor());
							
							System.out.println("DESPESAS - SALDO:"+conta.getSaldo());
							return repoLancamento.save(obj);
						}else {
							throw new IllegalArgumentException("SALDO INSUFICIENTE");
						}
						
						
					}else if(obj.getTipoMovimento() == TipoMovimento.RECEITAS.getCod()){
						
						conta.setSaldo(conta.getSaldo()+obj.getValor());
						System.out.println("RECEITA - SALDO:"+conta.getSaldo());
						
						return repoLancamento.save(obj);
						
					}else if(obj.getTipoMovimento() == TipoMovimento.TRANSFERENCIA.getCod()) {
						contaDestino = repoConta.findByLogin(obj.getContaDestino());
						
						if(contaDestino != null) {
							if(conta.getSaldo()<obj.getValor()) {
								conta.setSaldo(conta.getSaldo()-contaDestino.getSaldo());
								contaDestino.setSaldo(contaDestino.getSaldo()- conta.getSaldo());
							}else {
								throw new IllegalArgumentException("SALDO INSUFICIENTE PARA TRANSFERÊNCIA");
							}
						}
					}
				
			}else {
				throw new ObjectNotFoundException("Tipo de movimento inválido!");
			}
			
			
			
			
		}
		
		throw new ObjectNotFoundException("Usuário não encontrado!");
	}
	
}


