package com.stock.repository.commandeFournisseur;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CommandeFournisseurRepositoryImpl implements CommandeFournisseurRepository{

    @Override
    public <S extends CommandeFournisseur> S save(S s) {
        return null;
    }

    @Override
    public <S extends CommandeFournisseur> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<CommandeFournisseur> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<CommandeFournisseur> findAll() {
        return null;
    }

    @Override
    public Iterable<CommandeFournisseur> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(CommandeFournisseur commandeFournisseur) {

    }

    @Override
    public void deleteAll(Iterable<? extends CommandeFournisseur> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
