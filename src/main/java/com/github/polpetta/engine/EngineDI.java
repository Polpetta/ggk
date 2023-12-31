package com.github.polpetta.engine;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;

public class EngineDI extends AbstractModule {
    @Override
    protected void configure() {
        install(new FactoryModuleBuilder().build(PlayerFactory.class));
    }
}
