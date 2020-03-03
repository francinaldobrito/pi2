package com.unitins.projetointegrador2.security;

import com.unitins.projetointegrador2.model.PerguntasFrequentes;
import com.unitins.projetointegrador2.repository.PerguntasFrequentesRepository;

import com.unitins.projetointegrador2.model.Pessoa;
import com.unitins.projetointegrador2.repository.PessoaRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class ImplementsUserDetailsService implements UserDetailsService {

    private final PessoaRepository pessoaRepository;
    private final PerguntasFrequentesRepository perguntasFrequentesRepository;

    public ImplementsUserDetailsService(PessoaRepository pessoaRepository, PerguntasFrequentesRepository perguntasFrequentesRepository) {
        this.pessoaRepository = pessoaRepository;
        this.perguntasFrequentesRepository = perguntasFrequentesRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        Pessoa pessoa = pessoaRepository.findByCpf(login).get();

        if (pessoa == null) {
            throw new UsernameNotFoundException("Usuário não encontrado!");
        }
        
        //return new User(pessoa.getUsername(), pessoa.getPassword(), 
        //		true, true, true, true, pessoa.getAuthorities());
        return new User(pessoa.getCpf(), pessoa.getSenha(),
        		pessoa.getAuthorities());
    }
}
