package com.stock.repository.commandeClient;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CommandeClientRepositoryImpl implements CommandeClientRepository{
    @Override
    public List<CommandeClient> findAll() {
        return null;
    }

    @Override
    public List<CommandeClient> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<CommandeClient> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<CommandeClient> findAllById(Iterable<Long> iterable) {
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
    public void delete(CommandeClient commandeClient) {

    }

    @Override
    public void deleteAll(Iterable<? extends CommandeClient> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends CommandeClient> S save(S s) {
        return null;
    }

    @Override
    public <S extends CommandeClient> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<CommandeClient> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends CommandeClient> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<CommandeClient> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public CommandeClient getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends CommandeClient> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends CommandeClient> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends CommandeClient> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends CommandeClient> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends CommandeClient> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends CommandeClient> boolean exists(Example<S> example) {
        return false;
    }
}
